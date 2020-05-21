package com.raoSystem.createUser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       listCategory(request, response);
	}

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		DaoUserRole UserRoleDao = new DaoUserRole();
        try {
            request.setAttribute("karuna","hello Karuna Nidhi");

        	ArrayList<UserModel>  listCatagory = UserRoleDao.userRoleCheck();
            session.setAttribute("listCategory", listCatagory);
 			response.sendRedirect("Test.jsp");
  
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		listCategory(request, response);
	}

}





 
