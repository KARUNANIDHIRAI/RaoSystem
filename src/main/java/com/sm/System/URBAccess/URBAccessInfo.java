package com.sm.System.URBAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.SMInformation.SMFixedValue;


/**
 * Servlet implementation class URBAccessInfo
 */
public class URBAccessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public URBAccessInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNRLUxInfo":	
				erMsg= SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.ACTION_CREATING;
				UserRolesModel userRolesModel = new UserRolesModel();
				userRolesModel = URInputDataModel(userRolesModel,request);
				int exeStatus = HDAOURBAccess.UserRoles(userRolesModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
			case "xRetBKBRCD":	
				break; 	
			case "xRiBooksReturn":
				break; 	
			case "xRBKBRPendingL":	
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}
		finally {
			System.out.println(erMsg);
		}
	}
	private UserRolesModel URInputDataModel(UserRolesModel userRolesModel, HttpServletRequest request) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.WEBPAGE_INPUTVALUE_TOMODEL;
		try {
			Object []inputValues = request.getParameterValues("uRLInputData[]");
			userRolesModel.setRegNo(inputValues[0].toString());
			userRolesModel.setUserRole(inputValues[1].toString());
			userRolesModel.setStatus(SMFixedValue.STATUS); 
			userRolesModel.setCreatedBy("KBS TECHNOLOIES");
			userRolesModel.setCreatedOn(new Date());
			userRolesModel.setUpdatedBy("KBS TECHNOLOIES");
			userRolesModel.setUpdatedOn(new Date());
			msg += "\nuserRolesModel ->" +  userRolesModel;

			UserRolesDetailsModel uRDetailsModel = new UserRolesDetailsModel();
			uRDetailsModel.setRegNo(userRolesModel.getRegNo());
			uRDetailsModel.setfName(inputValues[2].toString());
			uRDetailsModel.setlName(inputValues[3].toString());
			uRDetailsModel.setMobileNo(inputValues[4].toString());
			uRDetailsModel.setEmailID(inputValues[5].toString());

			uRDetailsModel.setStatus(userRolesModel.getStatus());
			uRDetailsModel.setCreatedBy(userRolesModel.getCreatedBy());
			userRolesModel.setCreatedOn(new Date());
			uRDetailsModel.setUpdatedBy(userRolesModel.getUpdatedBy());
			uRDetailsModel.setUpdatedOn(new Date());
			msg += "\nuRDetailsModel ->" +  uRDetailsModel;

			userRolesModel.getURDetailModel().add(uRDetailsModel);
			uRDetailsModel.setURolesModel(userRolesModel);
			msg += SMFixedValue.ACTION_UPDATING + SMFixedValue.COMPLETED;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg);
		}
		return userRolesModel;
	}

}