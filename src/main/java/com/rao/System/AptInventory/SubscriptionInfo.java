package com.rao.System.AptInventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.raoSystem.Utility.Utilities;

public class SubscriptionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= "Step1: Start -";
		String Action = request.getParameter("Action");
		System.out.println("Action :" + Action);
		erMsg += Action;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		JsonArray jSubscription = new JsonArray();
		RwaSubscriptionModel subscriptionModel = new RwaSubscriptionModel();
		Integer spStatus = 0;
		System.out.println("Create Model OK ");
		
		try {
			switch (Action) {
			case "NewSubscription":
				subscriptionModel= UpdateSubsModelFormValue(subscriptionModel, request);
				erMsg += "Update Ok";
				showSubscriptionModel(subscriptionModel);
				erMsg += " ,ShowFunction OK ";
				try {
					spStatus = HDAOSubscription.SubscriptionNew(subscriptionModel,erMsg);
					if(spStatus== 1) {
						erMsg += "Create New OK ";
						jSubscription=HDAOSubscription.subscriptionList(subscriptionModel, erMsg);
						out.print(jSubscription.toJson());
						out.flush();
					}else {
						erMsg += "Duplicate / TEchnical OK "+spStatus ;
//						out.print("Duplicate / TEchnical OK " + spStatus );
//						out.flush();
					}
					
				} catch (Exception e) {
					System.out.println("Technical Error, Record Not created"+ e);
				}
				break;
			case "subView" : //view
				subscriptionModel.setRwaRegNo("MK106");
				jSubscription=HDAOSubscription.subscriptionList(subscriptionModel, erMsg);
				erMsg += "step 3: HDAO OK.";
				out.print(jSubscription.toJson());
				out.flush();
 				break; 
			case "subscriptionDel" :
				System.out.println("del case start");
				subscriptionModel.setRwaRegNo("MK106");
				subscriptionModel.setCreatedBy("KNRAI");
				subscriptionModel.setiDNO(Integer.parseInt(request.getParameter("subsdel")));;
//				RwaSubscriptionModel subsModel = new RwaSubscriptionModel(Integer.parseInt(request.getParameter("subsdel")),"MK106","KNRAI"); 
				erMsg += "show model OK, ";
				try {
					spStatus = HDAOSubscription.subscriptionDel(subscriptionModel, erMsg);
					System.out.println("update model ok");
					if(spStatus== 1) {
						erMsg += "Delete OK " + spStatus;
						jSubscription=HDAOSubscription.subscriptionList(subscriptionModel, erMsg);
						out.print(jSubscription.toJson());
						out.flush();
					}else {
						erMsg += spStatus== 2? " Invalid Transaction "+spStatus: "Technical Issue: "+ spStatus ;
						out.print(jSubscription.toJson());
						out.flush();
					}
				} catch (Exception e) {
					System.out.println("Error in deleting"+ e);
				}
				break;
			}
 			
		}catch(Exception e){
			System.out.println("Technical error:" +e);
			
		}finally {
			System.out.println(erMsg);
			
		}
		
	}
	private void showSubscriptionModel(RwaSubscriptionModel subscriptionModel) {
		System.out.println(" RWA NO:" +subscriptionModel.getRwaRegNo()+ ", SubsrciptionType: "+ subscriptionModel.getSubscriptionType()+ 
		"EffectiveDate: "+ subscriptionModel.getEffectiveDate()+ "Subscription : "+ subscriptionModel.getSubscription()+
		"Subscritpion Amt: "+ subscriptionModel.getSubscriptionAmt()+ "ExpenseType : "+ subscriptionModel.getExpenseType());
		
	}
	private RwaSubscriptionModel UpdateSubsModelFormValue(RwaSubscriptionModel subscriptionModel, HttpServletRequest request) {
		subscriptionModel.setRwaRegNo("MK106");
		subscriptionModel.setSubscriptionType(request.getParameter("SubscriptionType"));
		subscriptionModel.setEffectiveDate(Utilities.conDate(request.getParameter("subsDate")));
		subscriptionModel.setSubscription(request.getParameter("subscription"));
		subscriptionModel.setSubscriptionAmt(Integer.parseInt(request.getParameter("subAmt")));
		subscriptionModel.setExpenseType(request.getParameter("fixFloat"));
		subscriptionModel.setStatus("A");
		subscriptionModel.setCreatedBy("KNRAI");
		subscriptionModel.setCreatedOn(new Date());
		subscriptionModel.setUpdatedBy("KNRAI");
		subscriptionModel.setUpdatedOn(new Date());
		
		return subscriptionModel;
	}

}
