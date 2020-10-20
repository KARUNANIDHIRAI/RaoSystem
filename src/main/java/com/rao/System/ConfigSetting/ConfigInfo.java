package com.rao.System.ConfigSetting;

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

import com.rao.System.ContactUs.HDAOGenEnquiry;
import com.raoSystem.Utility.HDAOUtility;


public class ConfigInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= "Step1: Start";
		String Action = request.getParameter("Action");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "1"://new
				System.out.println("Step 1: Model OK");
				ConfigSettingModel cSModel = new ConfigSettingModel();
				cSModel = updateCgsJspValue(cSModel, request);
				erMsg +=" Model Update Ok, ";
				showConfValue(cSModel);
				erMsg +=" show Vale Ok, ";
		 		JsonArray JsonItemList= new JsonArray();
		 		int HDAspStatus = HDAOConfigSetting.newConfig(cSModel, erMsg);
				erMsg +=" Step 3.1: HDOA New Ok";
//				JsonItemList = HDAOConfigSetting.NewConfigSetting(cSModel, erMsg);
				JsonItemList = HDAOConfigSetting.RConfigList(cSModel, erMsg);
				erMsg +=" Step 3.1: HDOA rcList Ok";
				System.out.println("\n" + JsonItemList);
				out.print(JsonItemList.toJson());
				out.flush();
				
 				break;     
			case "getRCList" : //edit
				JsonArray iVList = new JsonArray();
				iVList=HDAOUtility.getAllRCIvList();
				erMsg += "step 2: HDAO OK.";
				out.print(iVList.toJson());
				out.flush();
 				break; 
			case "ivEDIT" : // edit
				JsonArray iVItem = new JsonArray();
				erMsg += "step 2: " + request.getParameter("Name");
				iVItem=HDAOConfigSetting.getRCIvItem(request.getParameter("Name"), "MK107",erMsg);
				erMsg += "step 3: HDAO getRCIvItem OK.";
				out.print(iVItem.toJson());
				out.flush();
				break;
			case "ivView" :
				ConfigSettingModel rcModel = new ConfigSettingModel();
				rcModel.setRwaNo("MK107");
		 		JsonArray rcItemList= new JsonArray();
		 		rcItemList = HDAOConfigSetting.RConfigList(rcModel, erMsg);
				erMsg +=" Step 3 : HDOA  Ok";
				System.out.println("\n" + rcItemList);
				out.print(rcItemList.toJson());
				out.flush();
				break;
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

	private void showConfValue(ConfigSettingModel cSModel) {
		System.out.println(cSModel.getNameType() + " , Start No." +cSModel.getStartNo()+ " ,Prefix :" + 
	                       cSModel.getPrefixStartNo());
		return;
	}

	private ConfigSettingModel updateCgsJspValue(ConfigSettingModel cSModel, HttpServletRequest request) {
		cSModel.setRwaNo("MK107");	
		cSModel.setNameType(request.getParameter("vType"));
		int startv = Integer.parseInt(request.getParameter("sValue"));
		cSModel.setStartNo(startv);
		cSModel.setPrefixStartNo(request.getParameter("pfix"));
		cSModel.setStatus("A"); 
		cSModel.setCreatedOn(new Date());
		cSModel.setCreatedBy("KNRAI");
		cSModel.setUpdatedOn(new Date());
		cSModel.setUpdatedBy("KNRAI");
		cSModel.setiDNO(123);
		return cSModel;
		
	}

}