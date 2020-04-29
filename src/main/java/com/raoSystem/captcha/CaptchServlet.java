package com.raoSystem.captcha;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Porgma", "No-Cache");
		response.setDateHeader("Max-Age", 0);
		String captcha = generateCapcha(5);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("Capthca", captcha);
		
		}
	private String generateCapcha(int captchalength) {
		String captcha ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<captchalength) {
			
			int index = (int) (random.nextFloat()*captcha.length());
			captchBuffer.append(captcha.substring(index,index+1));
			
		}
		
		
		return captchBuffer.toString();
		
	}
}
