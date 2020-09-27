package com.raoSystem.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.RwaReg.HDAORwa;
import com.rao.System.RwaReg.RwaRegModel;


public class ValidateUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//processRequest( request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= "Step1: Start";
		String valMsg=""; 
		String Action = request.getParameter("Action");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "refreshCaptcha":
				String captcha = processRequest(request, response);
				System.out.println("step 2: Refresh Captcha OK." + captcha);
				out.print(captcha);
				out.flush();
				break;
			case "Action" :
				String Captcha = request.getParameter("Captcha");
				String lableCaptcha = request.getParameter("lableCaptcha");				
				if(!Captcha.equals(lableCaptcha)) {
					String hDAOMessage= "Sorry your login fail due to technical error ! please try after sometime.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				
				System.out.println("Step 4: HDAO OK"  );
				break;
			}
		} catch (IOException e) {
			System.out.println("Technical Error"+ e);
			e.printStackTrace();
		}finally {
			System.out.println(erMsg);
		}
		

	}

	protected String  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Porgma", "No-Cache");
		response.setDateHeader("Max-Age", 0);
		String captcha = generateCapcha(5);

//		HttpSession session = request.getSession(true);
//		session.setAttribute("Captcha", captcha);
		return captcha;
	
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
