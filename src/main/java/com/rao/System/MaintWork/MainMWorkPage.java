package com.rao.System.MaintWork;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.google.gson.Gson;



public class MainMWorkPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");
		
		String erMsg="\n Step 0: Start ";
        String actType=	request.getParameter("Action");	
        String rwaRegNo="MK106";
		MWSearch mwSearch = new MWSearch();
		JsonArray JsonMWTypeList= new JsonArray();
		erMsg += "1. Model and JsonArray Object  OK," + "action :" + actType;
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch(actType) {
			case "WORKTYPE" :
				JsonMWTypeList=DAOServiceWork.MaintWorkType( rwaRegNo);
				erMsg+= " 4: DAO execute OK, ";
				out.print(JsonMWTypeList.toJson());
				out.flush();
				erMsg+= "\n: ----end of Service Type , ";
				break;
			case "1" : // View
				mwSearch=updateFormValueInModel(mwSearch, request);
				erMsg+= " 2. JSP Value to Model class OK, ";
				erMsg+= " 2.1 jsp Value :" + mwSearch.getRwaRegNo() +" " + mwSearch.getMWNO() + " " + mwSearch.getSPName() + "" 
						+  mwSearch.getFDate()+" " + mwSearch.getTDate() + " "+mwSearch.getMWType();
						
				JsonMWTypeList =  DAOServiceWork.MaintWorkView(mwSearch) ;
				System.out.println("\nSearch DAO RESULT :" + JsonMWTypeList);
				erMsg+= " 4: DAO execute OK, ";
				out.print(JsonMWTypeList.toJson());
				out.flush();
				erMsg+= "\n-----end --- Search return to JS , ";
				break;
			case "2" : // Edit
				MWEdit mwEdit = new MWEdit(rwaRegNo,request.getParameter("SONO"));
				erMsg+= "2.: Ajax Param to Edit MW , :" + mwEdit.getRwaRegNo() +" " + mwEdit.getMWNO() ;
				JsonMWTypeList =  DAOServiceWork.MaintWorkEdit(mwEdit) ;
				System.out.println("\nEdit DAO RESULT :" + JsonMWTypeList);
				erMsg+= " 4: DAO execute OK, ";
				out.print(JsonMWTypeList.toJson());
				out.flush();
				erMsg+= "\n -----end --- Edit return to JS ,  ";
				break;

			case "3" : // del
				mwSearch=updateJSPValueInModel(mwSearch, request);
				erMsg+= " 2. : AJAX search Param to Model class OK, ";
				erMsg+= " 2.1: formvalue :" + mwSearch.getRwaRegNo() +" " + mwSearch.getMWNO() + " " + mwSearch.getSPName() + "" 
						+  mwSearch.getFDate()+" " + mwSearch.getTDate() + " "+mwSearch.getMWType() + " " + mwSearch.delMWNO;
						
				JsonMWTypeList =  DAOServiceWork.MaintWorkDel(mwSearch) ;
				erMsg+= " 4: DAO execute OK, ";
				System.out.println("\nDEl DAO RESULT :" + JsonMWTypeList);
				out.print(JsonMWTypeList.toJson());
				out.flush();
				erMsg+= " \n-----end --- Del return to JS , ";
				break;
			case "MWWorkerInfo" :
				MWEdit mwWokerInfo = new MWEdit(rwaRegNo,request.getParameter("SONO"));
				erMsg+= "2.: Ajax Param to Edit MW , :" + mwWokerInfo.getRwaRegNo() +" " + mwWokerInfo.getMWNO() ;
				JsonMWTypeList =  DAOServiceWork.mwWokerInfoRetrieve(mwWokerInfo) ;
				System.out.println("\nEdit DAO RESULT :" + JsonMWTypeList);
				erMsg+= " 4: DAO execute OK, ";
				out.print(JsonMWTypeList.toJson());
				out.flush();
				erMsg+= "\n -----end OF mwWokerInfoRetrieve FOR Edit.";
				break;
			default:
				break;
			}
			System.out.println(erMsg);
		}catch(Exception e) {
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
				erMsg +=" Catch : Technical Issue ! Please contact to System Admin ";
				System.out.println(erMsg + "\n"+ e);
				response.sendRedirect("SuccessMsg.jsp");
		}
	}
	
	private MWSearch updateFormValueInModel(MWSearch mwSrchParam, HttpServletRequest request) {
		

		mwSrchParam.setRwaRegNo("MK106");
		mwSrchParam.setMWNO(request.getParameter("SONO"));
		mwSrchParam.setSPName(request.getParameter("SPName"));
		mwSrchParam.setFDate(request.getParameter("SDate"));
		mwSrchParam.setTDate(request.getParameter("EDate"));
		mwSrchParam.setMWType(request.getParameter("MWorkType"));
		mwSrchParam.setAction(request.getParameter("Action"));

		return mwSrchParam;
	}
	private MWSearch updateJSPValueInModel(MWSearch mwSrchParam, HttpServletRequest request) {
		

		mwSrchParam.setRwaRegNo("MK106");
		mwSrchParam.setMWNO(request.getParameter("SONO"));
		mwSrchParam.setSPName(request.getParameter("SPName"));
		mwSrchParam.setFDate(request.getParameter("SDate"));
		mwSrchParam.setTDate(request.getParameter("EDate"));
		mwSrchParam.setMWType(request.getParameter("MWorkType"));
		mwSrchParam.setAction(request.getParameter("Action"));
		mwSrchParam.setDelMWNO(request.getParameter("delMWNO"));

		return mwSrchParam;
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { HttpSession session =
	 * request.getSession(true); // listService(request, response,session); String
	 * erMsg="step 1.0 Created Calss Model "; String rwa="MK106"; try { List<MWType>
	 * listCatagory = DAOServiceWork.MaintWorkType(rwa);
	 * erMsg+="step 4.0 DAO Execute OK "; String json = new
	 * Gson().toJson(listCatagory);
	 * 
	 * response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(json);
	 * erMsg+="step 4.0 Json Response OK "; System.out.println(erMsg); } catch
	 * (Exception e) { erMsg+="step 4.1 Technical Problem [catch]";
	 * System.out.println(erMsg); }
	 * 
	 * }
	 */
	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { HttpSession session =
	 * request.getSession(true); String category = request.getParameter("category");
	 * String text = "Server replies: You selected category: " + category;
	 * response.setContentType("text/plain");
	 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(text); }
	 */
	/*
	 * private void listService(HttpServletRequest request, HttpServletResponse
	 * response, HttpSession session) throws ServletException, IOException { String
	 * erMsg="step 1.0 Created Calss Model "; String rwa="MK106"; try { List<MWType>
	 * listCatagory = DAOServiceWork.MaintWorkType(rwa);
	 * erMsg+="step 4.0 DAO Execute OK "; String json = new
	 * Gson().toJson(listCatagory);
	 * 
	 * response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(json);
	 * erMsg+="step 4.0 Json Response OK "; System.out.println(erMsg); } catch
	 * (Exception e) { erMsg+="step 4.1 Technical Problem [catch]";
	 * System.out.println(erMsg); } }
	 */
}	



