package com.rao.System.Apartment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RwaSubscriptionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			System.out.println("\nStep 1: RWA Subscription Model Creating ");
			
			AptModel user = new AptModel();

			user.setSubscriptionType(request.getParameter("SubscriptionType"));
			user.setRwaRegNo("MK108");
			user.setValidFrom(request.getParameter("ValidDateFrom"));
			user.setValidTo(request.getParameter("ValidDateTo"));
			user.setActionType(request.getParameter("ActionType"));

			System.out.println("Step 2: Parameter pass to SP to retrieve data--> RWA No" + user.getRwaRegNo() + " , Action Type-"
					+ user.getActionType() + " , Valid Date From :"+ user.getValidFrom() +" , Valid Date To - "+user.getValidTo() );
			user.setTranType("VIEW");
			try {
				user = DAOAPTInventory.RWASubscriptionRetriev(user);
				System.out.println("Step 4: SP status RWA Monthly Subscription :" + user.isValid() +": " + user.getSPstatus());

				/*
				 * if(user.getSPstatus()==3) { session.setAttribute("Message",
				 * " Technical Issue !Unable to Process Driver Information. Please contact to System Admin "
				 * ); response.sendRedirect("Success.jsp"); }
				 */
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " No Data Found. Please Enter Valid Search Criteria. ");
					System.out.println("Step 5: No Data Found. Please Enter Valid Search Criteria.");
					response.sendRedirect("Inventory/RWASubscriptionMainPage.jsp");
					break;
				case 1: // Record Exist [DB]
					user = SetValueToSessionVar(user, session);
					System.out.println("Step 5: set Session value Successfully" );
					switch (Integer.parseInt(user.getActionType())) {
					case 0:
						break;
					case 1:
						response.sendRedirect("Inventory/PreviewRwaSubscription.jsp");
						break;
					case 2: // Edit Information
						System.out.println("Step 5.1: Forward to Apartment Information/EditAPTInventory.jsp");
						response.sendRedirect("Inventory/RwaEditSubscription.jsp");
						break;
					}
					break;
				case 2:
					session.setAttribute("Message",	" Invalid Search Criteria. Please Contact System Admin.");
					System.out.println("Step 5:Invalid Search Criterai");
					response.sendRedirect("Inventory/RWASubscriptionMainPage.jsp");
					break;
				default:
					session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
		
			} catch (Exception e) {
				session.setAttribute("Message",
						" Technical Issue !Unable to update Apartment Monthly Subscription Information. Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		
		}
		
		public static AptModel SetValueToSessionVar(AptModel user, HttpSession session) {

			session.setAttribute("RwaRegNo", user.getRwaRegNo());
			session.setAttribute("UserID ", user.getUserID());

			session.setAttribute("SubscriptionType",(user.getSubscriptionType()=="1") ? "Fixed Charge" : "Floating Charge" );
			session.setAttribute("ValidDateFrom", user.getValidFrom());
			session.setAttribute("ValidDateTo", user.getValidTo());

			session.setAttribute("Fixcharge", user.getFlatFixCharge());
			session.setAttribute("AmcCharge", user.getAmcCharge());
			session.setAttribute("AuditCharge", user.getAuditCharge());
			session.setAttribute("GymCharge", user.getGymCharge());
			session.setAttribute("SwimmingPoolCharge", user.getSwmPoolCharge());
			session.setAttribute("MiscCharge", user.getMiscCharge());
		
			return user;
		
		}
	}
