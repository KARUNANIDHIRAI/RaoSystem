package com.sm.System.TransportVehicle;

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

/**
 * Servlet implementation class RouteVehicleInfo
 */
public class RouteVehicleInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				RouteSubModel routeSModel = new RouteSubModel();
				routeSModel.setRegNo(RegNo);
//				routeSModel = inputValueToRouteSModel(routeSModel,request,session);
				excStatus = HDAOTransport.getRouteNew(routeSModel);
				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				response.sendRedirect("SMSISystem/Transport/Route.jsp");

				break; 				
				
			case "xRouteBus":	// route Vehicle List based on school and route
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ROUTE_VEHICLE + SMFixedValue.ACTION_LIST ;
				JsonArrayList = HDAOTransport.getSchoolRoutBusList(RegNo,inputValueToRouteVehicleSubModel(request));
				erMsg+= SMFixedValue.ROUTE + SMFixedValue.ACTION_LIST +":";
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XSEiTBrInfo10":// Student ERP Item issued List	
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		} finally {
			System.out.println(erMsg);
		}
	}
	private int inputValueToRouteVehicleSubModel(HttpServletRequest request) {
		String erMsg =  SMFixedValue.update + SMFixedValue.ROUTE + SMFixedValue.INPUT_VALUES +SMFixedValue.TOMODEL ;
		int routePKID =0;
		try {
			routePKID = Integer.parseInt((String)SMUtilities.subtractUserData(request.getParameter("code"), 2));
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return routePKID;
	}

}
