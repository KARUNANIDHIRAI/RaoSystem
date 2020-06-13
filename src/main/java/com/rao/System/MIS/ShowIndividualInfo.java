package com.rao.System.MIS;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rao.System.DRV.DAODriverInfo;
import com.rao.System.DRV.DRVModel;
import com.raoSystem.Dweller.DAODweller;
import com.raoSystem.Dweller.DwellerInformation;
import com.raoSystem.Dweller.DwellerModel;
import com.raoSystem.FLTOWN.FLTOWNModel;
import com.raoSystem.HKM.DAOHKMInfo;
import com.raoSystem.HKM.HKMInformation;
import com.raoSystem.HKM.HKMModel;

public class ShowIndividualInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step 1: Information Model Creating ");
		int x =Integer.parseInt( request.getParameter("ActionType")) ;
		if(x==1){  
			FLTOWNModel user = new FLTOWNModel();
			user.setRwaRegNo("MK107");
		}else if(x==2){  
			DRVModel user = new DRVModel();
			user.setEmailId(request.getParameter("EmailId"));
			user.setMobileNO(request.getParameter("MobileNo"));
			user.setDLNO(request.getParameter("DLNO"));
					
			System.out.println(" Step 2: Parameter Valuse pass to SP to retrieve data--> Email ID" + user.getEmailId() + " , RWA Reg Code -"
					+ user.getRwaRegNo() + " , Mobile No.:"+ user.getMobileNO() +" , Action Type - "+user.getDLNO());
			user.setTranType("VIEW");
			try {
				System.out.println("Step 3: Calling DAO to retrieve Dweller Information ");
				user = DAODriverInfo.DRVInfoRetriev(user);
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " please Enter Valid Parameters");
					System.out.println(session.getAttribute("Message"));
					response.sendRedirect("ViewReports/ViewInfo.jsp");
					break;
				case 1: // Record Exist [DB]
					System.out.println("Step 5: set Dweller Information to Session Value");
					//user = HKMInformation.SetValueToSessionVar(user, session);
					response.sendRedirect("DRVInformation/PreviewDRVInfo.jsp");
					break;
				default:
					session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
			} catch (Exception e) {
				session.setAttribute("Message",
						" Technical Issue !Unable to View Information. Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		} else if(x==3){  
			HKMModel user = new HKMModel();
			user.setRwaRegNo("MK107");
			user.setEmailId(request.getParameter("EmailId"));
			user.setMobileNO(request.getParameter("MobileNo"));
			System.out.println(" Step 2: Parameter Valuse pass to SP to retrieve data--> Email ID" + user.getEmailId() + " , RWA Reg Code -"
					+ user.getRwaRegNo() + " , Mobile No.:"+ user.getMobileNO() +" , Action Type - "+user.getActionType());
			user.setTranType("VIEW");
			try {
				System.out.println("Step 3: Calling DAO to retrieve Dweller Information ");
				user = DAOHKMInfo.HKMInfoRetriev(user);
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " please Enter Valid Parameters");
					System.out.println(session.getAttribute("Message"));
					response.sendRedirect("ViewReports/ViewInfo.jsp");
					break;
				case 1: // Record Exist [DB]
					System.out.println("Step 5: set Dweller Information to Session Value");
					user = HKMInformation.SetValueToSessionVar(user, session);
					response.sendRedirect("HKMInformation/PreviewHKMInfo.jsp");
					break;
				default:
					session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
			} catch (Exception e) {
				session.setAttribute("Message",
						" Technical Issue !Unable to View Information. Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		} else if(x==4){  
			DwellerModel user = new DwellerModel();
			user.setRwaRegNo("MK107");
			user.setEmailId(request.getParameter("EmailId"));
			user.setMobileNO(request.getParameter("MobileNo"));
			System.out.println(" Step 2: Parameter Valuse pass to SP to retrieve data--> Email ID" + user.getEmailId() + " , RWA Reg Code -"
					+ user.getRwaRegNo() + " , Mobile No.:"+ user.getMobileNO() +" , Action Type - "+user.getActionType());
			user.setTranType("VIEW");
			try {
				System.out.println("Step 2: Calling DAO to retrieve Dweller Information ");
				user = DAODweller.DwellerInfoRetriev(user);
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " please Enter Valid Parameters");
					System.out.println(session.getAttribute("Message"));
					response.sendRedirect("ViewReports/ViewInfo.jsp");
					break;
				case 1: // Record Exist [DB]
					System.out.println("Step 3: set Dweller Information to Session Value");
					user = DwellerInformation.SetValueToSessionVar(user, session);
					response.sendRedirect("DwellerInformation/PreviewDwellerInfo.jsp");
					break;
				default:
					session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
			} catch (Exception e) {
				session.setAttribute("Message",
						" Technical Issue !Unable to View Information. Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		}	
	}
}