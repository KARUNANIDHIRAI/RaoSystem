package com.raoSystem.userLoginRegistration;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRole
 */
public class UserRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCategory(request, response);
	}
	
    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DaoUserLoginRole daoUser = new DaoUserLoginRole();
    	System.out.println("start servlet");
        try {
        	System.out.println("knrai");
            List<userRoleType> listCatagory = daoUser.userLoginRoleCheck();
            request.setAttribute("listCategory", listCatagory);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("Test.jsp");
            dispatcher.forward(request, response);
 
        } catch (Exception e) {
        	System.out.println("error in servlet :" + e);
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	listCategory(request, response); 
    	System.out.println("Shikha");
	  	}
	}
