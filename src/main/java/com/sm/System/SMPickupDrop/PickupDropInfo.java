package com.sm.System.SMPickupDrop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMUtilities;
import com.sm.System.Transport.HDAOTransport;
import com.sm.System.Transport.RouteModel;
import com.sm.System.Transport.RoutePickUpDropModel;
import com.sm.System.Transport.RouteSubModel;


public class PickupDropInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		String RegNo=session.getAttribute(SMFixedValue.PARM_REGNO)==null?"":session.getAttribute("RegNo").toString();
		RegNo = "MK308";
		String hDAOMessage= "";
		int excStatus =0;
		Boolean result;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg+= Action;
		
		
		
		try {
			switch (Action) {
			case "xtNRouteInf":	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				SMPickupDropSubModel sMPDSModel= new SMPickupDropSubModel();
				sMPDSModel.setRegNo(RegNo);
				sMPDSModel = inputValueToRouteSModel(sMPDSModel,request,session);
				excStatus = HDAOTransport.getRouteNew(sMPDSModel);
				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				response.sendRedirect("SMSISystem/Transport/Route.jsp");
				break; 				
			case "genxRouteLX":	// retriev route List based on school 
				break; 	
			case "XSEiTBrInfo10":// Student ERP Item issued List	
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		} finally {
			System.out.println(erMsg);
		}

		private RouteModel inputValueToRouteModel(RouteModel routeModel, HttpServletRequest request, HttpSession session) {
			String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.PICKUP_DROP_POINT + SMFixedValue.INPUT_VALUES  
			        +SMFixedValue.TOMODEL ;
			Object []inputValues = request.getParameterValues("xPKAndDRP[]");
			try {
				routeModel.setRouteName(SMUtilities.subtractStringAndNumber(inputValues[0].toString(), 1));
				routeModel.setRouteDescription(inputValues[1].toString());
				routeModel.setStatus(SMFixedValue.STATUS);
				routeModel.setUserRefInfo(SMUtilities.getUserInfo(session));
				erMsg+=  SMFixedValue.INPUT_VALUES  + routeModel;
				
				 RoutePickUpDropModel routePDModel = new RoutePickUpDropModel();
				 routePDModel.setRegNo(routeModel.getRegNo());
				 routePDModel.setPickupDropType(inputValues[1].toString());
				 routePDModel.setPickDropSNo(inputValues[2].toString());
				 routePDModel.setPickupDropPoint(inputValues[3].toString());
				 routePDModel.setPickupDropTime(inputValues[4].toString());
				 routePDModel.setStatus(SMFixedValue.STATUS);
				 routePDModel.setUserRefInfo(SMUtilities.getUserInfo(session));
				 
				 routeModel.getRoutePickUpDropModel().add(routePDModel);
				 routePDModel.setPickUpDropModel(routeModel);
				erMsg+= routePDModel;
			} catch (Exception e) {
				erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
			}finally {
				System.out.println(erMsg);
			}
			return routeModel;
		}
	
	}

}
