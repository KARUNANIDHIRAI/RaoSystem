package com.sm.System.SupplierMaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
import com.sm.System.SMInformation.SMFixedValue;

public class SupplierMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		SupplierMasterModel supplierMasterModel = new SupplierMasterModel();
		supplierMasterModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNrXSupMS":	// CREATE NEW INFORMATION
				erMsg= SMFixedValue.BOOK_MS_CREATING;

				supplierMasterModel = supplierMasterModel(supplierMasterModel,request);
				excStatus = HDAOSupplierMaster.SupplierMasterNew(supplierMasterModel);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOSupplierMaster.getSupplierMasterList(supplierMasterModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
			case "xRiSUPMSData": // GENERATE SUPPLIER MASTER LIST
				JsonArrayList = HDAOSupplierMaster.getSupplierMasterList(supplierMasterModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				
				break; 	
			case "xRSUPMSiD": // REMOVE SUPPLIER MASTER INFORMATION
				supplierMasterModel = supplierMasteriDNOToModel(supplierMasterModel,request);
				excStatus = HDAOSupplierMaster.remSupplierMasteriDNO(supplierMasterModel);
				JsonArrayList = HDAOSupplierMaster.getSupplierMasterList(supplierMasterModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRSUPMSiUpd":	// UPDATE SUPPLIER MASTER INFORMATION AGAINST IDNO
				supplierMasterModel = supplierMasterModel(supplierMasterModel,request);
				supplierMasterModel.setiDNO(Integer.parseInt((String)request.getParameter("cid")));
				excStatus = HDAOSupplierMaster.SupplierMasterUpdateInformation(supplierMasterModel);
				hDAOMessage= excStatus>0? SMFixedValue.EXEC_UPDATE_MSG:"0 "+ SMFixedValue.EXEC_UPDATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				erMsg+= SMFixedValue.SUPPLIER_MASTER +SMFixedValue.ACTION_UPDATE +SMFixedValue.COMPLETED;
				response.sendRedirect("SMSISystem/SMSystems/SupplierMaster.jsp");
//			    RequestDispatcher rd=request.getRequestDispatcher("SMSISystem/SMSystems/SupplierMaster.jsp");  
//			    rd.forward(request, response);  
				break; 	
			case "xRSUPMSiDInfo":	// RETRIEVE SUPPLIER MASTER INFORMATION AGAINST IDNO
				supplierMasterModel = supplierMasteriDNOToModel(supplierMasterModel,request);
				JsonArrayList = HDAOSupplierMaster.updSupplierMasterInfo(supplierMasterModel);
				erMsg+= SMFixedValue.SUPPLIER_MASTER +SMFixedValue.ACTION_REMOVING +SMFixedValue.COMPLETED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}
		finally {
			System.out.println(erMsg);
		}
	}
	
	private SupplierMasterModel supplierMasteriDNOToModel(SupplierMasterModel supplierMasterModel,HttpServletRequest request){
		String erMsg =  SMFixedValue.SUPPLIER_MASTER  + SMFixedValue.INPUT_VALUES +  SMFixedValue.UPDATE_MODEL;
		try {
			supplierMasterModel.setiDNO(Integer.parseInt((String)request.getParameter("supMSIDNO")));
			supplierMasterModel.setStatus(SMFixedValue.DELETE_STATUS);
			erMsg+= "\n"+SMFixedValue.SUPPLIER_MASTER  + SMFixedValue.INPUT_VALUES +"\n" + supplierMasterModel;
			erMsg+= "\n"+SMFixedValue.SUPPLIER_MASTER  + SMFixedValue.INPUT_VALUES  + SMFixedValue.COMPLETED;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return supplierMasterModel;
	}
	
	private SupplierMasterModel supplierMasterModel(SupplierMasterModel supplierMasterModel,HttpServletRequest request){
		String erMsg =  SMFixedValue.BOOK_MS_INPUT_UPDMODEL;
		try {
			supplierMasterModel.setSupName(request.getParameter("supName"))     ;
			supplierMasterModel.setSupCode(request.getParameter("supCode"))     ;
			supplierMasterModel.setSupCategory(request.getParameter("Category"))    ;
			supplierMasterModel.setFacebook(request.getParameter("Facebook"))    ;
			supplierMasterModel.setLinkedin(request.getParameter("Linkdin"))     ;
			supplierMasterModel.setTwitter(request.getParameter("Twitter"))     ;
			supplierMasterModel.setCreatedBy("KNRAI")                           ;
			supplierMasterModel.setCreatedOn(new Date())                        ;
			supplierMasterModel.setUpdatedBy(supplierMasterModel.getCreatedBy());
			supplierMasterModel.setUpdatedOn(supplierMasterModel.getCreatedOn());
			supplierMasterModel.setStatus(SMFixedValue.STATUS);
			erMsg+= "\n"+ SMFixedValue.SUPPLIER_MASTER+ SMFixedValue.INPUT_VALUES +"\n" + supplierMasterModel;
			SupplierMasterContact supplierMasterContact  = new SupplierMasterContact();
			supplierMasterContact.setRegNo(supplierMasterModel.getRegNo());
			supplierMasterContact.setMobileNo(request.getParameter("mobileNo"));
			supplierMasterContact.setPhoneNo(request.getParameter("phoneNo"));
			supplierMasterContact.setEmailID(request.getParameter("email"));
			supplierMasterContact.setStatus(supplierMasterModel.getStatus());
			supplierMasterContact.setContactRef(SMFixedValue.CONTACT_CATEGORY);
			supplierMasterContact.setUpdatedBy(supplierMasterModel.getCreatedBy());
			supplierMasterContact.setUpdatedOn(supplierMasterModel.getCreatedOn());
			supplierMasterModel.getSupMasterContact().add(supplierMasterContact);
			supplierMasterContact.setSupContactModel(supplierMasterModel);
			erMsg+= "\n"+ SMFixedValue.SUPPLIER_MASTER+ SMFixedValue.INPUT_VALUES +"\n" + supplierMasterContact;
			if(!request.getParameter("HoMobileNo").equals("")
				&& !request.getParameter("HoPhoneNo").equals("")
				&& !request.getParameter("HoEmail").equals("")) {
				SupplierMasterContact supplierMasterHOContact  = new SupplierMasterContact();
				supplierMasterHOContact.setRegNo(supplierMasterModel.getRegNo());
				supplierMasterHOContact.setMobileNo(request.getParameter("HoMobileNo"));
				supplierMasterHOContact.setPhoneNo(request.getParameter("HoPhoneNo"));
				supplierMasterHOContact.setEmailID(request.getParameter("HoEmail"));
				supplierMasterHOContact.setStatus(supplierMasterModel.getStatus());
				supplierMasterHOContact.setContactRef(SMFixedValue.CONTACT_CATEGORY_HO);
				supplierMasterHOContact.setUpdatedBy(supplierMasterModel.getCreatedBy());
				supplierMasterHOContact.setUpdatedOn(supplierMasterModel.getCreatedOn());

				supplierMasterModel.getSupMasterContact().add(supplierMasterHOContact);
				supplierMasterHOContact.setSupContactModel(supplierMasterModel);
				erMsg+= "\n"+ SMFixedValue.SUPPLIER_MASTER+ SMFixedValue.INPUT_VALUES +"\n" + supplierMasterHOContact;
			}
			SupplierMasterAddressModel supplierMasterAddressModel = new SupplierMasterAddressModel();
			supplierMasterAddressModel.setRegNo(supplierMasterModel.getRegNo());
			supplierMasterAddressModel.setAddress(request.getParameter("Address"));
			supplierMasterAddressModel.setSector(request.getParameter("Sector"));
			supplierMasterAddressModel.setCity(request.getParameter("City"));
			supplierMasterAddressModel.setState(request.getParameter("State"));
			supplierMasterAddressModel.setCountry(request.getParameter("country"));
			supplierMasterAddressModel.setPincode(request.getParameter("postalCode"));
			supplierMasterAddressModel.setCategory(SMFixedValue.ADDRESS_CATEGRORY);
			supplierMasterAddressModel.setStatus(SMFixedValue.STATUS);
			supplierMasterAddressModel.setUpdatedBy(supplierMasterModel.getCreatedBy());
			supplierMasterAddressModel.setUpdatedOn(supplierMasterModel.getCreatedOn());
			erMsg+= "\n"+ SMFixedValue.SUPPLIER_MASTER+ SMFixedValue.INPUT_VALUES +"\n" + supplierMasterAddressModel;
			System.out.println("supplierMasterAddressModel: "+ supplierMasterAddressModel);
			
			supplierMasterModel.getSupMAddress().add(supplierMasterAddressModel);
			supplierMasterAddressModel.setSupAddModel(supplierMasterModel);
	
			if(!request.getParameter("HoAddress").equals("")) {
				SupplierMasterAddressModel supplierMasterHOAddressModel = new SupplierMasterAddressModel();
				supplierMasterHOAddressModel.setRegNo(supplierMasterModel.getRegNo())        ;
				supplierMasterHOAddressModel.setAddress(request.getParameter("HoAddress"))   ;
				supplierMasterHOAddressModel.setSector(request.getParameter("HoSector"))     ;
				supplierMasterHOAddressModel.setCity(request.getParameter("HoCity"))         ;
				supplierMasterHOAddressModel.setState(request.getParameter("HoState"))       ;
				supplierMasterHOAddressModel.setCountry(request.getParameter("athCountry"))  ;
				supplierMasterHOAddressModel.setPincode(request.getParameter("HOPostalCode"));
				supplierMasterHOAddressModel.setCategory(SMFixedValue.ADDRESS_CATEGORY_HO)   ;
				supplierMasterHOAddressModel.setStatus(SMFixedValue.STATUS)                  ;
				supplierMasterHOAddressModel.setUpdatedBy(supplierMasterModel.getCreatedBy());
				supplierMasterHOAddressModel.setUpdatedOn(supplierMasterModel.getCreatedOn());

				supplierMasterModel.getSupMAddress().add(supplierMasterHOAddressModel);
				supplierMasterHOAddressModel.setSupAddModel(supplierMasterModel);
				erMsg+= "\n"+ SMFixedValue.SUPPLIER_MASTER+ SMFixedValue.INPUT_VALUES +"\n" + supplierMasterHOAddressModel;
			}
			erMsg = "\n"+ SMFixedValue.SUPPLIER_MASTER  + SMFixedValue.UPD_MODEL;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
			
		}finally {
			System.out.println(erMsg);
		}
		return supplierMasterModel;
	}
}
