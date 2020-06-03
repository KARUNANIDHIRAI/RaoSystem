/*
 * package com.rao.System.SSP;
 * 
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * public class SSPInfoEdit extends HttpServlet { private static final long
 * serialVersionUID = 1L;
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { HttpSession session =
 * request.getSession(true); System.out.println("Step1: KNRAI model creating ");
 * 
 * SSPModel user = new SSPModel();
 * 
 * user.setEmailId(request.getParameter("EmailId"));
 * user.setRwaRegNo(request.getParameter("rwaRegNo"));
 * user.setDLNO(request.getParameter("DLNO"));
 * user.setActionType(Integer.parseInt(request.getParameter("ActionType")));
 * System.out.println("Parameter Valuse pass to SP -->"+user.getEmailId()+" : "
 * +user.getRwaRegNo() + ": " +user.getDLNO()+ ": " +user.getActionType());
 * user.setTranType("EDIT");
 * 
 * 
 * try { user = DaoNewSSP.UpdateSSPInfo(user); if (user.isValid()) {
 * switch(user.getSPstatus()){ case 0: // Record Not Exist [DB]
 * session.setAttribute("Message"," Invalid Email Id  / RWA Registraion No.");
 * System.out.println("Invalid Email Id  / RWA Registraion No.") ;
 * response.sendRedirect("SSPInformation/SSPMainPage.jsp"); break; case 1: //
 * Record Exist [DB]
 * 
 * session.setAttribute("EmailID", user.getEmailId());
 * session.setAttribute("RwaRegNo",user.getRwaRegNo());
 * 
 * session.setAttribute("UserID ",user.getUserID());
 * session.setAttribute("inputFName",user.getFname());
 * session.setAttribute("inputLName", user.getLname());
 * session.setAttribute("inputGender", user.getGender());
 * session.setAttribute("inputDOB", user.getDOB());
 * session.setAttribute("inputMobile", user.getMobileNO());
 * session.setAttribute("inputEmail4", user.getEmailId());
 * session.setAttribute("inputAadharNO.", user.getAadharNO());
 * session.setAttribute("inputPanCardNo", user.getPanCardNo());
 * session.setAttribute("inputFFName", user.getFFName());
 * session.setAttribute("inputFLName", user.getFLName());
 * session.setAttribute("inputFGender", user.getFGender());
 * session.setAttribute("inputFMobile", user.getFMobileNO());
 * session.setAttribute("inputFEmail", user.getFEmailId());
 * session.setAttribute("inputFAadharNO", user.getFAadharNO()); // permanent
 * Address session.setAttribute("inputPAddress", user.getPAddress());
 * session.setAttribute("inputPBlock", user.getBlockNO());
 * session.setAttribute("inputPSector", user.getSector());
 * session.setAttribute("inputPCity", user.getCity());
 * session.setAttribute("inputPState", user.getState());
 * session.setAttribute("inputPCountry", user.getCountry());
 * session.setAttribute("inputPPincode", user.getZipCode()); //sspc Address
 * session.setAttribute("inputCAddress", user.getCAddress());
 * session.setAttribute("inputCBlock", user.getCBlock());
 * session.setAttribute("inputCSector", user.getCSector());
 * session.setAttribute("inputCCity", user.getCCity());
 * session.setAttribute("inputCState", user.getCState());
 * session.setAttribute("inputCCountry", user.getCCountry());
 * session.setAttribute("inputCPincode", user.getCZipCode());
 * 
 * //ssp Arm Details
 * 
 * session.setAttribute("inputGunNo", user.getArmsNo());
 * session.setAttribute("inputGunType", user.getArmsType());
 * session.setAttribute("inputGunMadeCity", user.getArmsMadeFromCity());
 * session.setAttribute("inputPurchaseFrom", user.getArmsPurchaseFrom());
 * session.setAttribute("inputPurchaseYear", user.getArmsPurchaseYear());
 * session.setAttribute("inputGunIssuedName", user.getArmsIssuedInName());
 * 
 * // ssp dl details
 * 
 * session.setAttribute("inputLicenseNO", user.getDLNO());
 * session.setAttribute("inputLicenseCity", user.getDLIssuefromCity());
 * session.setAttribute("inputLicenseDate", user.getDLIssueDate());
 * session.setAttribute("inputExpiryDate", user.getDLExpiryDate());
 * session.setAttribute("DLIRTOAddress", user.getDLIRTOAddress());
 * session.setAttribute("DLBlockNO", user.getDLBlockNO());
 * session.setAttribute("DLSector", user.getDLSector());
 * session.setAttribute("DLCity", user.getDLCity());
 * session.setAttribute("DLState", user.getDLState());
 * session.setAttribute("DLCountry", user.getDLCountry());
 * session.setAttribute("DLZipCode", user.getDLZipCode());
 * 
 * // ssp ex organization
 * 
 * session.setAttribute("inputPreOrgName", user.getOrgName());
 * session.setAttribute("inputEmpNO", user.getEmployeeNo());
 * session.setAttribute("inputDesignation", user.getDesignation());
 * session.setAttribute("inputDateJoin", user.getDOJ());
 * session.setAttribute("inputDateRelev", user.getDOR());
 * session.setAttribute("inputReproting", user.getReportingOfficer());
 * session.setAttribute("inputRepEmail", user.getOEmailID());
 * session.setAttribute("inputOAddress", user.getOAdress());
 * session.setAttribute("inputOBlock", user.getOBlock());
 * session.setAttribute("inputOSector", user.getOSector());
 * session.setAttribute("inputOCity", user.getOCity());
 * session.setAttribute("inputOState", user.getOState());
 * session.setAttribute("inputOCountry", user.getOcountry());
 * session.setAttribute("inputOpincode", user.getOPinCode());
 * 
 * 
 * session.setAttribute("ACTYPE", "EDIT");
 * response.sendRedirect("SSPInformation/EditSSPInfo.jsp"); break; case 2:
 * session.setAttribute(
 * "InvalidFPWDMsg"," Invalid Email Id  / RWA Registraion No.");
 * System.out.println("Invalid Email Id  / RWA Registraion No.") ; break;
 * default: session.setAttribute(
 * "InvalidFPWDMsg"," Technical Issue ! Please contact to System Admin ");
 * break; } } else { if (user.getSPstatus()==2){ } else { } } }catch (Exception
 * e){ System.out.println("Technical Issue ! Please contact to System Admin ") ;
 * session.setAttribute(
 * "InvalidFPWDMsg"," Catch Technical Issue (User Not Created)! Please contact to System Admin "
 * ); }
 * 
 * 
 * 
 * }
 * 
 * }
 */