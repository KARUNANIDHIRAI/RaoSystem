package com.raoSystem.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String FILE_TYPE = "png";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest( request, response);
	}

    @Override 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		try {
			String code= request.getParameter("txtCaptcha");
			String code1= (String) session.getAttribute("Captcha");

			if (code.equals(code1)){
				request.getSession(false).removeAttribute("CaptchaErrMsg");
				request.getSession(false).removeAttribute("captcha");
				System.out.println("Captcha:"+ session.getAttribute("CaptchaErrMsg"));
			}else {
				session.setAttribute("CaptchaErrMsg", "Enter Valid Captcha");
				response.sendRedirect("LoginPage.jsp");
				System.out.println("Captcha:"+ session.getAttribute("CaptchaMsg"));
			}
		} catch (IOException e) {
			session.setAttribute("CaptchaMsg", "Enter Valid Captcha");
			response.sendRedirect("LoginPage.jsp");
			System.out.println("Error in process Capthcha :" + e);
		}

		try {
			System.out.println("Step 1: UserLogin");
			UserLogin user = new UserLogin();
			
			user.setLoginID(request.getParameter("inputLogin"));
		    user.setPassword(request.getParameter("inputPassword"));
			
		    BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder(); 
		    String Password = PasswordEncoder.encode(user.getPassword());
		    System.out.println("Compare 2:"+ PasswordEncoder.matches(user.getPassword(),Password));
		    
			System.out.println("Step 2 : Call DaoLogin");
			try {
				System.out.println("stepl 4");
				user= DaoLogin.check(user);
				if (user.isValid()) {	
		            session.setAttribute("currentUser","Hi "+user.getfName()+" Ji");
		            System.out.println((String)session.getAttribute("firstname")) ;
		         	response.sendRedirect("RwaHomePage.jsp");
				} else {
		            System.out.println("Invalid user ID / Password") ;
					session.setAttribute("InvalidLoginMsg","Invalid user ID / Password");
					response.sendRedirect("LoginPage.jsp");
				}
			} catch(Exception e){
				System.out.println("Error in Check function data store procedure");
				session.setAttribute("ErrMsg","Execution issues  ");
			}
		} catch (Exception e) {
				e.printStackTrace();
		}		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Porgma", "No-Cache");
		response.setDateHeader("Max-Age", 0);
		String captcha = generateCapcha(5);

		HttpSession session = request.getSession(true);
		session.setAttribute("Captcha", captcha);
		session.setAttribute("CaptchaMsg", "Enter Captcha");
		
		int width=160, height=35;
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.OPAQUE);
		Graphics graphics = bufferedImage.createGraphics();
		graphics.setFont(new Font("Arial", Font.BOLD,20));
		graphics.setColor(new Color(51, 153, 255));
		graphics.fillRect(0,0, width, height);
		graphics.setColor(new Color(255,255,255));
		graphics.drawString(captcha, 20,25);
		
		response.setContentType("Image/png");
		OutputStream outputStream =  response.getOutputStream();
		ImageIO.write(bufferedImage, FILE_TYPE, outputStream);
		outputStream.close();
	}
	private String generateCapcha(int captchalength) {
		String captcha ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<captchalength) {
			int index = (int) (random.nextFloat()*captcha.length());
			captchBuffer.append(captcha.substring(index,index+1));
		}
		return captchBuffer.toString();
	}
	
}
