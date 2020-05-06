package com.raoSystem.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CaptchServlet
 */

public class CaptchServlet extends HttpServlet {
	private static final long serialVersionUID = 5840561187921381581L;
	public static final String FILE_TYPE = "png";

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest( request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("CaptchaMsg", "Enter Captcha");

		String code= request.getParameter("txtCaptcha");
		String code1= (String) session.getAttribute("Captcha");
		if (code.equals(code1)){
			request.getSession(false).removeAttribute("CaptchaMsg");
			request.getSession(false).removeAttribute("captcha");
			
			response.sendRedirect("RwaHomePage.jsp");
		}else {
			session.setAttribute("CaptchaMsg", "Enter Valid Captcha");
			response.sendRedirect("LoginPage.jsp");
		}

		
		
		
		
		
	}
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
			response.setHeader("Cache-Control", "No-Cache");
			response.setDateHeader("Expires", 0);
			response.setHeader("Porgma", "No-Cache");
			response.setDateHeader("Max-Age", 0);
			String captcha = generateCapcha(5);
			
			int width=160, height=35;
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.OPAQUE);
			Graphics graphics = bufferedImage.createGraphics();
			graphics.setFont(new Font("Arial", Font.BOLD,20));
			graphics.setColor(new Color(51, 153, 255));
			graphics.fillRect(0,0, width, height);
			graphics.setColor(new Color(255,255,255));
			graphics.drawString(captcha, 20,25);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("Captcha", captcha);
			session.setAttribute("CaptchaMsg", "Enter Captcha");
			
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
