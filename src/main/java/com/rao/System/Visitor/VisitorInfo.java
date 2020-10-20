package com.rao.System.Visitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.raoSystem.Utility.Utilities;

public class VisitorInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		String erMsg = "Step: 1 Start ";
		String Action = request.getParameter("Action");
		System.out.println("Action: "+ Action);
		erMsg += Action;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		VisitorGPModel vGPModel = new VisitorGPModel();
		int spStatus = 0;

		try {
			switch (Action) {
			case "NewVisitor":
				erMsg += "Step 1.1 Model OK:";
				vGPModel = updateVisitorToJsp(vGPModel, request);
				showVisitorModel(vGPModel);
				spStatus= HDAOVisitor.visitorNew(vGPModel, erMsg);
				erMsg +=spStatus==1?" issue Gate pass Ok":" Issue Gate Pass Fail";
				break;
			case "VVInfo":
				erMsg += "VVInfo";
				JsonArray vVInfoList = new JsonArray();
				vGPModel = updateViewParm(vGPModel,request);
				erMsg += "Show value OK: " ;
				showVvInfoModel(vGPModel);
				erMsg += "updateViewParm OK: " ;
				vVInfoList= HDAOVisitor.vVInfoList(vGPModel,erMsg);
				erMsg += "vVInfoList OK:";
				System.out.println("vVInfoList: "+ vVInfoList.toJson());
				out.print(vVInfoList.toJson());
				out.flush();
				break;
			}	
		}catch(Exception e) {
			System.out.println("\n Error Catch :" + e );
		} finally {
			System.out.println("\n " + erMsg);
		}
	}
	private void showVvInfoModel(VisitorGPModel vGPModel) {
		System.out.println(" RwaNo: "+ vGPModel.getRwaRegNo()+ " Mobile: "+ vGPModel.getvMobileNo()+ " ApptNo:"+
				vGPModel.getResAptNo()+ " FDate: "+ vGPModel.getVisitDate()+ "TDate:"+ vGPModel.getCreatedOn());
	}
	private VisitorGPModel updateViewParm(VisitorGPModel vGPModel, HttpServletRequest request) {
		
 		try {
			vGPModel.setRwaRegNo("MK106");
			vGPModel.setvMobileNo(request.getParameter("vMobileNo"));
			vGPModel.setResAptNo(request.getParameter("resAptTowerNO"));
			vGPModel.setVisitDate(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("vDateFrom")));	
			System.out.println("visit Date: "+ vGPModel.getVisitDate());
			vGPModel.setCreatedOn(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("vDateTo"))); // Used because no option for toDate in model

			 String originalString = "20-01-2020";
		      Date date = new SimpleDateFormat("dd-mm-yyyy").parse(originalString);
		      String newstr = new SimpleDateFormat("MM/dd/yyyy").format(date);
		       System.out.println("date: "+date +"\n"+newstr+"\n");			
 		
 		} catch (ParseException e) {
			System.out.println("Error in updateViewParm: \n"+e);
		}	
		
		return vGPModel;
	}
	private void showVisitorModel(VisitorGPModel vGPModel) {
		System.out.println("vRwaRegNo: "+vGPModel.getRwaRegNo()+ "vFName"+ vGPModel.getvFName()+ "vLname: "+ vGPModel.getvLname()+
		"vMobileNo: "+ vGPModel.getvMobileNo()+ "vInTime: "    + vGPModel.getvInTime()    + "vOutTime: "+ vGPModel.getvOutTime() +
		"VDate: "    + vGPModel.getVisitDate()+ "vIDProff: "   + vGPModel.getIdProof()    + "vIDdoc: "  + vGPModel.getIdDocName()+
		"VehivleNo: "+ vGPModel.getVehicleNo()+ "VehicleName: "+ vGPModel.getVehicleName()+ "RFNAme: "  + vGPModel.getResFName() +
		"rLname:"    + vGPModel.getResLName() + "resFltNo: "   + vGPModel.getResFltNo()   + "resAptNo: "+ vGPModel.getResAptNo());
		
		ArrayList<VisitorAddressModel> showvAdd = new ArrayList<>();
		showvAdd = (ArrayList<VisitorAddressModel>) vGPModel.getVAdd();
		for (VisitorAddressModel vAdd:showvAdd) {
			System.out.println("rwaRegNo:" + vAdd.getRwaRegNo()+ "vAddress:"+ vAdd.getvAddress()+ "vCity: "+ vAdd.getvCity()+
					"vCountry: "+ vAdd.getvCountry()+ "vState: "+ vAdd.getvState()+ "vPinCode: "+ vAdd.getvPinCode());
		}
	}
	private VisitorGPModel updateVisitorToJsp(VisitorGPModel vGPModel, HttpServletRequest request) {
	     try {
	 		vGPModel.setRwaRegNo("MK106");
			vGPModel.setvFName(request.getParameter("vFname"));
			vGPModel.setvLname(request.getParameter("vLname"));
			vGPModel.setvMobileNo(request.getParameter("vMobileNo"));
			vGPModel.setvInTime(new SimpleDateFormat("HH:mm").parse((String)request.getParameter("vInTime")));
  	        vGPModel.setvOutTime(new SimpleDateFormat("HH:mm").parse((String)request.getParameter("vOutTime")));
//			vGPModel.setVisitDate(Utilities.conDate(request.getParameter("vDate")));
			vGPModel.setVisitDate(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("vDate")));	
				vGPModel.setIdProof(request.getParameter("vIdentityNo"));
				vGPModel.setIdDocName(request.getParameter("IdDocType"));
				vGPModel.setVehicleNo(request.getParameter("VehcilNo"));
				vGPModel.setVehicleName(request.getParameter("vehicleType"));
				vGPModel.setResFName(request.getParameter("resFname"));
				vGPModel.setResLName(request.getParameter("resLname"));
				vGPModel.setResFltNo(request.getParameter("resAptTowerNO"));
				vGPModel.setResAptNo(request.getParameter("resFlatNo"));
				vGPModel.setCreatedBy("KNRAI");
				vGPModel.setCreatedOn(new Date());
				
				VisitorAddressModel vAddress = new VisitorAddressModel();
				vAddress.setRwaRegNo("MK106");
				vAddress.setvAddress(request.getParameter("vAddress"));
				vAddress.setvCity(request.getParameter("vCity"));
				vAddress.setvCountry(request.getParameter("country"));
				vAddress.setvPinCode(request.getParameter("vPostalCode"));
				vAddress.setvState(request.getParameter("vState"));
				
				vGPModel.getVAdd().add(vAddress);
				vAddress.setVGPModel(vGPModel);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vGPModel;
	}

}
