package com.rao.System.AptInventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.ConfigSetting.ConfigSettingModel;
import com.rao.System.MASItem.DAOItem;


public class AptInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= "Step1: Start";
		String Action = request.getParameter("Action");
		System.out.println("Action :" + Action);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		JsonArray aptInvt = new JsonArray();
		AptInventoryModel aptInvModel = new AptInventoryModel();
		
		try {
			switch (Action) {
			case "AddAptInv"://new
				aptInvModel = updateAptJspValue(aptInvModel, request);
				erMsg +="1.1 AddAptInv Model Update Ok, ";
				showAptValue(aptInvModel);
				erMsg +="1.2 show Model Value Ok, ";
		 		int HDAspStatus = HDAOAptInventory.newAptInvtory(aptInvModel, erMsg);
				erMsg +=" Step 3.1: HDOA New Ok";
				aptInvt = HDAOAptInventory.aptInventoryList(aptInvModel, erMsg);
				erMsg +=" Step 3.1: HDOA rcList Ok";
				out.print(aptInvt.toJson());
				out.flush();
				
 				break;     
			case "aptInvtrView" : //view
			    aptInvModel.setRwaRegNo("MK106");
				aptInvt=HDAOAptInventory.aptInventoryList(aptInvModel, erMsg);
				erMsg += "step 3: HDAO OK.";
				System.out.println("\n knrai :" + aptInvt.toJson());
				out.print(aptInvt.toJson());
				out.flush();
 				break; 
			case "aptInventoryDel" : //view
				erMsg +="Start delete process:";
			    aptInvModel.setRwaRegNo("MK106");
			    aptInvModel.setCreatedBy("KNRAI");
				aptInvModel.setiDNO(Integer.parseInt(request.getParameter("aptInvdel")));
				System.out.println("aptInvdel : "+ aptInvModel.getiDNO());
				
			    try {
					int aptDelStatus=HDAOAptInventory.aptInventorydel(aptInvModel, erMsg);
					erMsg += "step 3: HDAO OK. Del Status" + aptDelStatus ;
					if (aptDelStatus==1){
						aptInvt = HDAOAptInventory.aptInventoryList(aptInvModel, erMsg);
						erMsg +=" Step 3.1: HDOA rcList Ok";
						System.out.println("json array list" +aptInvt.size() );
						out.print(aptInvt.toJson());
						out.flush();
					}
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JsonObject jobj = new JsonObject();
					jobj.put("SNO", "1 Technical Error" );
					aptInvt.add(jobj);
					System.out.println("aptInvt : "+ aptInvt);
					out.print(aptInvt.toJson());
					out.flush();
					
					System.out.println("Technical Error : " + erMsg);
				}
 				break; 

			/*
			 * case "ivEDIT" : // edit erMsg += "step 2: " + request.getParameter("Name");
			 * // aptInvt=HDAOAptInventory.getRCIvItem(request.getParameter("Name"),
			 * "MK107",erMsg); erMsg += "step 3: HDAO getRCIvItem OK."; break; case "ivView"
			 * : ConfigSettingModel rcModel = new ConfigSettingModel();
			 * rcModel.setRwaNo("MK107"); aptInvt =
			 * HDAOAptInventory.aptInventoryList(aptInvModel, erMsg); erMsg
			 * +=" Step 3 : HDOA  Ok"; break;
			 * 
			 */	
 			}
		} catch (HibernateException hibernate) {
			System.out.println("Technical Error: \n"+ hibernate);
		} catch (Exception e)	{
			System.out.println("Technical Error: \n"+ e);
		}finally {
			session.setAttribute("Message","Technical Error");
			System.out.println(erMsg);
		}
	}
	private AptInventoryModel updateAptJspValue(AptInventoryModel aptInvModel, HttpServletRequest request) {
		  aptInvModel.setRwaRegNo("MK106");
		  aptInvModel.setCreatedBy("KNRAI");
		  aptInvModel.setTowerNo(request.getParameter("inputTowerNo"));
		  aptInvModel.setFlatCategory(request.getParameter("inputFlatCategoryNo"));
		  aptInvModel.setFlatSize(Integer.parseInt(request.getParameter("inputSizeOfFlat")));
		  aptInvModel.setFlatNoFrom(request.getParameter("inputFltStartNo"));
		  aptInvModel.setFlatNoTo(request.getParameter("inputFltEndNo"));
		  aptInvModel.setStatus("A"); 
		  aptInvModel.setCreatedOn(new Date());
		  aptInvModel.setCreatedBy("KNRAI");
		  aptInvModel.setUpdatedOn(new Date());
		  aptInvModel.setUpdatedBy("KNRAI");
		  
		return aptInvModel;
	}
	private void showAptValue(AptInventoryModel aptInvModel) {
		System.out.println("RwaRegNo: "+ aptInvModel.getRwaRegNo()+"TowerNo: " + aptInvModel.getTowerNo() 
						+ " , Flat Catg:." +aptInvModel.getFlatCategory()+
						" ,FSize :" + aptInvModel.getFlatSize()+ "FSNo: " + aptInvModel.getFlatNoFrom()
						+ "FENo: "+ aptInvModel.getFlatNoTo());
	}
}
