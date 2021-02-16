package com.raoSystem.FLTOWN;

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

import com.rao.System.AptInventory.AptInventoryModel;
import com.rao.System.AptInventory.HDAOAptInventory;

public class VehicleInfo extends HttpServlet {
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
		JsonArray vehJarray = new JsonArray();
		HVehicleInfoModel vehModel = new HVehicleInfoModel();
		
		try {
			switch (Action) {
			case "VehNew"://new
				vehModel = updateVehcileJSPValue(vehModel, request);
				erMsg +=" Model Update Ok, ";
				showVehicleInfo(vehModel);
				erMsg +=" show Model Value Ok, ";
		 		String HDAOspStatus = HDAOVehicleInfo.VehicleNew(vehModel, erMsg);
				erMsg +=" Step 3.1: HDOA Vehicle Ok";
				vehJarray = HDAOVehicleInfo.VehicleList(vehModel,"flatwise", erMsg);
				erMsg +=" Step 3.1: HDOA List Ok";
				out.print(vehJarray.toJson());
				out.flush();
 				break;     
			case "VehView" : //view
				vehModel = updateVehcileJSPValue(vehModel, request);
				erMsg +=" Model Update Ok, ";
			    vehJarray = HDAOVehicleInfo.VehicleList(vehModel,"flatwise", erMsg);
			    erMsg +=  "step 3: HDAO OK."; 
			    System.out.println("\n knrai :" + vehJarray.toJson());
			    out.print(vehJarray.toJson());
			    out.flush();
				break; 
			case "VehInfoDel" : //view
				erMsg +=" 1.1 VehInfoDel process:";
				vehModel = updateVehcileJSPValue(vehModel, request);
				vehModel.setiDNO(Integer.parseInt(request.getParameter("vehInoDelId"))); //
				erMsg +=" Model Update Ok, ";
				System.out.println("aptInvdel : "+ vehModel.getiDNO());
				try { 
					String vehDelStatus = HDAOVehicleInfo.vehInfoIdDel(vehModel, erMsg);
					erMsg += "step 3: HDAO OK. Del Status :" + vehDelStatus ;
					if (vehDelStatus.equals("1")){
					    vehJarray = HDAOVehicleInfo.VehicleList(vehModel,"flatwise", erMsg);
						erMsg  +=" Step 3.1: HDOA rcList Ok"; 
						out.print(vehJarray.toJson()); 
						out.flush();
					}
				}catch (Exception e) { // TODO Auto-generated catch block JsonObject jobj = new
					  System.out.println("Technical Error : " + erMsg);
				}
				break; 
			case "VehTypeList" :
			    vehJarray = HDAOVehicleInfo.VehicleTypeList(erMsg);
			    erMsg +=  "step 3: HDAO OK."; 
			    System.out.println("\n knrai :" + vehJarray.toJson());
			    out.print(vehJarray.toJson());
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
	private HVehicleInfoModel updateVehcileJSPValue(HVehicleInfoModel vehModel, HttpServletRequest request) {
		  vehModel.setRwaRegNo("MK106");
		  vehModel.setAptNo(request.getParameter("aptNo"));
		  vehModel.setFlatNo(request.getParameter("flatNo"));
		  vehModel.setVehicleType(request.getParameter("VehType"));
		  vehModel.setVehicleName(request.getParameter("vehModel"));
		  vehModel.setVehicleNo(request.getParameter("vehNo"));
		  vehModel.setVehicleColor(request.getParameter("vehColor"));
		  vehModel.setManufacturer(request.getParameter("vehManfacturer"));
		  vehModel.setCreatedOn(new Date());
		  vehModel.setCreatedBy("KNRAI");
		  vehModel.setUpdatedOn(new Date());
		  vehModel.setUpdatedBy("KNRAI");
		return vehModel;
	}
	
	private void showVehicleInfo(HVehicleInfoModel vehModel) {
		System.out.println("RWANo: " +vehModel.getRwaRegNo() + ", Apt.No.: "+vehModel.getAptNo()+ ",FaltNo.: "+vehModel.getFlatNo());
		  System.out.println("Veh Type: "+vehModel.getVehicleType() +", Manufacuterer :"+ vehModel.getManufacturer() +",Vehicle No:"
		  +vehModel.getVehicleNo() +", Vehicle Name :" + vehModel.getVehicleName() +", Color:" +vehModel.getVehicleColor());
		  System.out.println(" UID :" +vehModel.getCreatedBy() );
	}

}
