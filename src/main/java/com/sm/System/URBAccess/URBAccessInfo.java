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
		UserRolesModel userRolesModel = new UserRolesModel();
		userRolesModel.setRegNo("MK308");
		JsonArray userRoleList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xURLGR1xMe": // Remove User Role Group
				userRolesModel = URListCriteriaIDToModel(userRolesModel,request);
				excStatus = HDAOURBAccess.sMUserRolesDelIDNO(userRolesModel);
				if(excStatus>0) {
					userRoleList = HDAOURBAccess.sMUserRolesList(userRolesModel);
					erMsg += SMFixedValue.EXEC_QUERY_MSG;
					out.print(userRoleList.toJson());
					out.flush();
				}
				break;
			case "xNuRLGruoup":	// Create New User Role Group
				erMsg += SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.ACTION_CREATING;
				userRolesModel = userRGInputDataModel(userRolesModel,request);
				excStatus = HDAOURBAccess.sMUserRolesGroup(userRolesModel);
				if (excStatus==2) {
					session.setAttribute(SMFixedValue.MESSAGE,SMFixedValue.DATA_ALREADY_EXIST );
					erMsg+= SMFixedValue.DATA_ALREADY_EXIST;
					userRoleList = HDAOURBAccess.getDuplicateMsg();
					System.out.println(SMFixedValue.DATA_ALREADY_EXIST);
				}else {
					userRoleList = HDAOURBAccess.sMUserRolesList(userRolesModel);
				}
				
				out.print(userRoleList.toJson());
				out.flush();
				break; 				
/*
			case "xNRLUxInfo":	// Create New User LOGIN
				erMsg += SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.ACTION_CREATING;
				userRolesModel = URInputDataModel(userRolesModel,request);
				excStatus = HDAOURBAccess.sMUserRoles(userRolesModel);
				if(excStatus==1) {
					userRoleList = HDAOURBAccess.getSMUserRoleLoginInfo(userRolesModel);
				}
				out.print(userRoleList.toJson());
				out.flush();
				break; 
*/
			case "xNRLUxInfo":	// Create New User LOGIN
				SMSIUserLoginSubModel userLoginSubModel  = new SMSIUserLoginSubModel();
				erMsg += SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.ACTION_CREATING;
				userLoginSubModel = uULoginModel(userLoginSubModel, request);
				excStatus = HDAOURBAccess.sMUserLoginCreate(userLoginSubModel);
				if(excStatus==1) {
					userRoleList = HDAOURBAccess.getSMSIUserLoginInfo(userLoginSubModel);
				}
				out.print(userRoleList.toJson());
				out.flush();
				break; 
			case "iX3UserRolelist":	// Generate User Role List
				userRolesModel = URListCriteriaToModel(userRolesModel,request);
				erMsg += SMFixedValue.update + SMFixedValue.COMPLETED;
				userRoleList = HDAOURBAccess.sMUserRolesList(userRolesModel);
				erMsg += SMFixedValue.EXEC_QUERY_MSG;
				out.print(userRoleList.toJson());
				out.flush();
				break; 	
			case "getSMUserRoles":	// Generate User Role List for dropbox
				userRolesModel = URListCriteriaToModel(userRolesModel,request);
				erMsg += SMFixedValue.update + SMFixedValue.COMPLETED;
				userRoleList = HDAOURBAccess.getSMUserRoles(userRolesModel);
				erMsg += SMFixedValue.EXEC_QUERY_MSG;
				out.print(userRoleList.toJson());
				out.flush();
				break; 	
			case "iX3UserRolelistID": // Generate User Role List Detils based on selected ID
				userRolesModel = URListCriteriaIDToModel(userRolesModel,request);
				erMsg += SMFixedValue.update + SMFixedValue.COMPLETED;
				userRoleList = HDAOURBAccess.sMUserRolesListID(userRolesModel);
				erMsg += SMFixedValue.EXEC_QUERY_MSG;
				out.print(userRoleList.toJson());
				out.flush();
				break; 	
			case "iX3UserRolelistIDD":	
				int uRIDD = subtractNumber((String)request.getParameter("iDDURL"),1);
				int uRIDFK = subtractNumber((String)request.getParameter("iDDURL"),2);
				userRolesModel.setiDNO(uRIDD);
				userRolesModel.setStatus(SMFixedValue.STATUS); 		
				//userRolesModel.setiDNO(Integer.parseInt((String)request.getParameter("iDDURL")));
				//userRolesModel = URListCriteriaIDDToModel(userRolesModel,request);
				erMsg += SMFixedValue.ACTION_UPDATING +  SMFixedValue.ACTION_CRITERIA+  SMFixedValue.COMPLETED;
				excStatus = HDAOURBAccess.sMUserRolesRemIDD(userRolesModel);
				if(excStatus>0) {
					userRolesModel.setiDNO(uRIDFK);
					userRoleList = HDAOURBAccess.sMUserRolesListID(userRolesModel);
				}
				erMsg += SMFixedValue.EXEC_QUERY_MSG;
				out.print(userRoleList.toJson());
				out.flush();
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}
		finally {
			System.out.println(erMsg);
		}
	}
	private UserRolesModel userRGInputDataModel(UserRolesModel userRolesModel, HttpServletRequest request) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.INPUT_VALUES;
		try {
//			userRolesModel.setRegNo(request.getParameter("registrationNumber"));
			userRolesModel.setUserRole(request.getParameter("xUrgRole")); 		
			userRolesModel.setStatus(SMFixedValue.STATUS); 		
			userRolesModel.setCreatedBy("KBS TECHNOLOIES");
			userRolesModel.setCreatedOn(new Date());
			userRolesModel.setUpdatedBy(userRolesModel.getCreatedBy());
			userRolesModel.setUpdatedOn(new Date());
			msg += "\nuserRolesModel ->" +  userRolesModel;
			msg += SMFixedValue.ACTION_UPDATING +  SMFixedValue.ACTION_CRITERIA+  SMFixedValue.COMPLETED;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg +"\n" + SMFixedValue.OUTPUT + "\n"+ userRolesModel);
		}
		return userRolesModel;
	}
	private UserRolesModel URListCriteriaToModel(UserRolesModel userRolesModel, HttpServletRequest request) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.LIST_GENERATING + SMFixedValue.ACTION_CRITERIA;
		try {
//			userRolesModel.setRegNo("MK308");
			userRolesModel.setStatus(SMFixedValue.STATUS); 		
			msg += SMFixedValue.ACTION_UPDATING +  SMFixedValue.ACTION_CRITERIA+  SMFixedValue.COMPLETED;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg);
		}
		return userRolesModel;
	}
	private UserRolesModel URListCriteriaIDToModel(UserRolesModel userRolesModel, HttpServletRequest request) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.LIST_GENERATING + SMFixedValue.ACTION_CRITERIA;
		try {
//			userRolesModel.setRegNo("MK308");
			userRolesModel.setiDNO(Integer.parseInt((String)request.getParameter("iDURL")));
			userRolesModel.setStatus(SMFixedValue.STATUS); 	
			msg += SMFixedValue.ACTION_UPDATING +  SMFixedValue.ACTION_CRITERIA+  SMFixedValue.COMPLETED;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg);
		}
		return userRolesModel;
	}
	private int subtractNumber(String numString, int id) {
		int pos = numString.indexOf("/");
		int uRID=0;
		try {
			uRID = id==2?Integer.parseInt(numString.substring(pos+1)) :Integer.parseInt(numString.substring(0,pos));
		} catch (NumberFormatException e) {
			System.out.println(SMFixedValue.EXEC_CATCH_MSG +"\n" +  e);			
		}
		return uRID;
	}
/*
	private UserRolesModel URInputDataModel(UserRolesModel userRolesModel, HttpServletRequest request) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.WEBPAGE_INPUTVALUE_TOMODEL;
		try {
			Object []inputValues = request.getParameterValues("uRLInputData[]");
			userRolesModel.setRegNo(inputValues[0].toString());
			userRolesModel.setUserRole(inputValues[1].toString());
			userRolesModel.setStatus(SMFixedValue.STATUS); 
			userRolesModel.setCreatedBy("KBS TECHNOLOIES");
			userRolesModel.setCreatedOn(new Date());
			userRolesModel.setUpdatedBy(userRolesModel.getCreatedBy());
			userRolesModel.setUpdatedOn(new Date());
			msg += "\nuserRolesModel ->" +  userRolesModel;
			UserRolesDetailsModel uRDetailsModel = new UserRolesDetailsModel();
			uRDetailsModel.setRegNo(userRolesModel.getRegNo());
			uRDetailsModel.setfName(inputValues[2].toString());
			uRDetailsModel.setlName(inputValues[3].toString());
			uRDetailsModel.setMobileNo(inputValues[4].toString());
			uRDetailsModel.setEmailID(inputValues[5].toString());
			uRDetailsModel.setUserCategory(inputValues[6].toString());
			uRDetailsModel.setuLPWD(inputValues[7].toString());
			uRDetailsModel.setUserCode(inputValues[8].toString());
			
			uRDetailsModel.setStatus(userRolesModel.getStatus());
			uRDetailsModel.setCreatedBy(userRolesModel.getCreatedBy());
			uRDetailsModel.setCreatedOn(userRolesModel.getCreatedOn());
			uRDetailsModel.setUpdatedBy(userRolesModel.getCreatedBy());
			uRDetailsModel.setUpdatedOn(userRolesModel.getUpdatedOn());
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
*/	
	private SMSIUserLoginSubModel uULoginModel(SMSIUserLoginSubModel uLoginSubModel, HttpServletRequest request) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.WEBPAGE_INPUTVALUE_TOMODEL;
		try {
			Object []inputValues = request.getParameterValues("uRLInputData[]");
			uLoginSubModel.setRegNo(inputValues[0].toString());
			uLoginSubModel.setUserRoleIdFK(Integer.parseInt((String) inputValues[1]));
			uLoginSubModel.setfName(inputValues[2].toString());
			uLoginSubModel.setlName(inputValues[3].toString());
			uLoginSubModel.setMobileNo(inputValues[4].toString());
			uLoginSubModel.setEmailID(inputValues[5].toString());
			uLoginSubModel.setUserCategory(inputValues[6].toString());
			uLoginSubModel.setuLPWD(inputValues[7].toString());
			uLoginSubModel.setUserCode(inputValues[8].toString());
			
			uLoginSubModel.setStatus(SMFixedValue.STATUS);
			uLoginSubModel.setCreatedBy("KBS TECHNOLOGY");
			uLoginSubModel.setCreatedOn(new Date());
			uLoginSubModel.setUpdatedBy("KBS TECHNOLOGY");
			uLoginSubModel.setUpdatedOn(new Date());
			msg += "\nuRDetailsModel ->" +  uLoginSubModel;

			msg += SMFixedValue.ACTION_UPDATING + SMFixedValue.COMPLETED;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg);
		}
		return uLoginSubModel;
	}

}