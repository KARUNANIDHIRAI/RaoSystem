package com.sm.System.Transport;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.RwaReg.HDAORwa;
import com.raoSystem.Utility.Utilities;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMUtilities;

public class RouteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				routeSModel = inputValueToRouteSModel(routeSModel,request,session);
				excStatus = HDAOTransport.getRouteNew(routeSModel);
				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				response.sendRedirect("SMSISystem/Transport/Route.jsp");

				break; 				
				
			case "genxRouteLX":	// retriev route List based on school 
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ROUTE + SMFixedValue.ACTION_LIST  + SMFixedValue.INFORMATION ;
				RouteSubModel routeS1Model = new RouteSubModel();
				routeS1Model.setRegNo(RegNo);
				JsonArrayList = HDAOTransport.getRouteList(routeS1Model.getRegNo());
				erMsg+= SMFixedValue.ROUTE + SMFixedValue.ACTION_LIST +":";
				
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xtNRoutePKPDR":	// Create New pickup / Drop point based on school
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.PICKUP_DROP_POINT + SMFixedValue.INFORMATION ;
				RouteModel routeModel = new RouteModel();
				routeModel.setRegNo(RegNo);
				routeModel = inputValueToRouteModel(routeModel,request,session);
				excStatus = HDAOTransport.routePickupDropNew(routeModel, session);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOTransport.getRoutePickUPDropList(routeModel.getRegNo(), routeModel.getRouteName());
				erMsg+= SMFixedValue.ROUTE + SMFixedValue.ACTION_LIST +":";
				
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRIPdpInfoX":	// Generate pickup / Drop point based on transport route's idNo 
				erMsg= SMFixedValue.GENERATING + SMFixedValue.PICKUP_DROP_POINT + SMFixedValue.INFORMATION ;
				JsonArrayList = HDAOTransport.getRoutePickUPDropList(Integer.parseInt(request.getParameter("Code")));
				erMsg+= SMFixedValue.COMPLETED+":";
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xSSPDPr":	// Generate pickup / Drop point based on transport route's idNo and Pick/Tdrop Type 
				erMsg= SMFixedValue.GENERATING + SMFixedValue.PICKUP_DROP_POINT + SMFixedValue.INFORMATION ;
//				String routeName= SMUtilities.subtractStringAndNumber(request.getParameter("code").toString(), 1);	
				int routeid= Integer.parseInt(request.getParameter("code").toString());	
				JsonArrayList = HDAOTransport.getRoutePickUPDropList(RegNo,routeid,request.getParameter("xPDPType"));
//				JsonArrayList = HDAOTransport.getRoutePickUPDropList(RegNo,routeName,request.getParameter("xPDPType"));
				erMsg+= SMFixedValue.COMPLETED+":";
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRmPDPInfoX":	// delete pickup drop point based on transport route's idNo 
				excStatus= SMUtilities.subtractIntAndInt((String)request.getParameter("Code"), 1);
				result = HDAOTransport.delPDPByiDNO(excStatus);
				if(result){
					excStatus= SMUtilities.subtractIntAndInt((String)request.getParameter("Code"), 2);
					JsonArrayList = HDAOTransport.getRoutePickUPDropList(excStatus);
					out.print(JsonArrayList.toJson());
					out.flush();
				}
				break; 	
			case "xRMtrRoute": // delete Route based on school and route idNo	
				result = HDAOTransport.delRouteByiDNO(Integer.parseInt((String)request.getParameter("Code")));
				hDAOMessage= result? SMFixedValue.EXEC_REMOVE_MSG:"0 "+ SMFixedValue.EXEC_REMOVE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOTransport.getRouteList(RegNo);
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

	private RouteSubModel inputValueToRouteSModel(RouteSubModel routeModel, 
			HttpServletRequest request, HttpSession session) {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.ROUTE + SMFixedValue.INPUT_VALUES +SMFixedValue.TOMODEL ;
		try {
			routeModel.setRouteName(request.getParameter("tRCode"));
			routeModel.setRouteDescription(request.getParameter("tRName"));
			routeModel.setStatus(SMFixedValue.STATUS);
			routeModel.setUserRefInfo(SMUtilities.getUserInfo(session));
			erMsg+= SMFixedValue.INPUT_VALUES +  routeModel;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return routeModel;
	}
}	
