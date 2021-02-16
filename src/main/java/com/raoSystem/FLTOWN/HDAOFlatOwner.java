package com.raoSystem.FLTOWN;

import java.sql.SQLException;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOFlatOwner {

	public static String FOInfoCreate(HFlatOwnerModel hFOInfo, String erMsg) {
		String erMsgSql ="3";
		erMsg += " Step 3.1 Start FOInfoCreate : ";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
		StoredProcedureQuery spQuery =  sessionObj.createStoredProcedureQuery("FOwnInfoCreate");
		spQuery.registerStoredProcedureParameter("UID",      String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("RwaRegNo", String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("AptNo",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FlatNo",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FName",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("LName",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("Gender",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("MobileNo", String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("PhoneNo",  String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("EmailID",  String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FFName",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FLName",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("Status",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("erMsgSQL", String.class , ParameterMode.OUT);

		erMsg += " Parm Reg OK : ";

		spQuery.setParameter("UID",     hFOInfo.getCreatedBy());
		spQuery.setParameter("RwaRegNo",hFOInfo.getRwaRegNo());
		spQuery.setParameter("AptNo",   hFOInfo.getAptNo());
		spQuery.setParameter("FlatNo",  hFOInfo.getFlatNo());
		spQuery.setParameter("FName",   hFOInfo.getfName());
		spQuery.setParameter("LName",   hFOInfo.getlName());
		spQuery.setParameter("Gender",  hFOInfo.getGender());
		spQuery.setParameter("MobileNo",hFOInfo.getMobileNo());
		spQuery.setParameter("PhoneNo", hFOInfo.getPhoneNo());
		spQuery.setParameter("EmailID", hFOInfo.getEmailId());
		spQuery.setParameter("FFName",  hFOInfo.getfFName());
		spQuery.setParameter("FLName",  hFOInfo.getfLName());
		spQuery.setParameter("Status",  hFOInfo.getStatus());

		erMsg += " Parm Set OK : ";
		spQuery.execute();
		erMsg += "Execute OK ";
		erMsgSql = (String)spQuery.getOutputParameterValue("erMsgSQL");
		sessionObj.close();	
		erMsg += "\n erMsgSql : "+ erMsgSql;
		}catch(HibernateException HBE) {
			erMsgSql="3";
			System.out.println(" FOInfoCreate Hibernate Exception :"+ HBE);
			
		}catch(Exception e) {
			erMsgSql="3";
 			System.out.println(" FOInfoCreate Technical Error :"+ e);
		}
		finally {
			System.out.println("erMsg: " + erMsg+ "sp" );
		}
		return erMsgSql;
	}

}
