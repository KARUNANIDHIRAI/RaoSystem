package com.rao.System.ContactUs;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import com.raoSystem.Utility.Collaboration;
import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.ProductDemo;
import com.raoSystem.daoConnection.HibernateDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

public class HDAOGenEnquiry {
	public static int gENewInfo(GenEnqModel gEModel, String erMsg) {
		int geEnqStatus=0;
		Transaction transaction = null;
		erMsg += " Step 3: HDAO start " ;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction= sessionObj.beginTransaction();
	          erMsg += " Step 3.1: Began Tran OK. " ;
	    	  sessionObj.save(gEModel);
	          erMsg += " Step 3.2: Save OK. " ;
	          sessionObj.getTransaction().commit();
	          erMsg = " General Enquiry Logs Successfully" ;
	          geEnqStatus=1;
	      } catch(HibernateException hibernateEx) {
              System.out.println("\n" + erMsg+" "+ ".......Transaction Is Being Rolled Back.......\n" + hibernateEx);
	      }catch (Exception e) {
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	          System.out.println("\nerMsg" +"\n"+e +"\n");
		}
		return geEnqStatus;
	}

	public static int BusEnqInfo(BusEnqModel bEModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int beEnqStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(bEModel);
			sessionObj.getTransaction().commit();
			beEnqStatus=1;
		}catch(HibernateException hibernateEx) {
			if (transaction !=null) {
				transaction.rollback();
			}
            System.out.println("\n" + erMsg+" "+ ".......Transaction Is Being Rolled Back.......\n" + hibernateEx);
    		return beEnqStatus;
	   }catch (Exception e) {
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	          System.out.println("\nerMsg" +"\n"+e +"\n");
	  		return beEnqStatus;
	   }
		return beEnqStatus;
	}
	
	public static int clbEnqInfo(ClbEnqModel cLModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int EnqStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(cLModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			System.out.println("hibernate commit transaction HDAQ1");
			EnqStatus=1;
		}catch(HibernateException hibernateEx) {
			erMsg +=".......HibernateException Transaction Is Being Rolled Back....... \n" + hibernateEx;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
    		return EnqStatus;
	   }catch (Exception e) {
			erMsg +=".......exception ....... \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return EnqStatus;
 	   }
		return EnqStatus;
	}
	public static int pfdEnqInfo(PDEnqModel pfdEModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int EnqStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(pfdEModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			System.out.println("hibernate commit transaction HDAQ1");
			EnqStatus=1;
		}catch(HibernateException hibernateEx) {
			erMsg +=".......HibernateException Transaction Is Being Rolled Back....... \n" + hibernateEx;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
    		return EnqStatus;
	   }catch (Exception e) {
			erMsg +=".......exception ....... \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return EnqStatus;
 	   }
		return EnqStatus;
	}
	
	@SuppressWarnings("unused")
	public static JsonArray getAllcountryList() {
		int geEnqStatus=0;
		Transaction transaction = null;
		JsonArray countrylist= new JsonArray();
		String erMsg;
		erMsg = " Step 2: HDAO start " ;
		System.out.println("knrai: "+erMsg);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	          erMsg += " 2.1: Began Tran OK. " ;
//	          CountryList rows=  (CountryList) sessionObj.get(CountryList.class,"AD");
	          ArrayList<CountryList> rows=  (ArrayList<CountryList>) sessionObj.createQuery("from CountryList").list();
	          for( CountryList row:rows) {
	        	  JsonObject jsonObject = new JsonObject();
	        	  jsonObject.put("id", row.getCode());
	        	  jsonObject.put("name", row.getName());
	        	  countrylist.add(jsonObject);
	          }
	          System.out.println(countrylist);
	          erMsg += " 2.2: Save OK. " ;
	          sessionObj.getTransaction().commit();
	          erMsg = " 2.3 :GEnquiry save Successfully" ;
	          geEnqStatus=1;
	      }catch (Exception e) {
	          System.out.println("\n"+erMsg +"\n"+e );
		}finally {
			System.out.println("Execution Status:\n"+erMsg);
		}
		return countrylist;
	}


	public static JsonArray getCollaborationList(String erMsg) {
		Transaction transaction = null;
		JsonArray Poductlist= new JsonArray();
		erMsg = " Step 2: HDAO start " ;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	          erMsg += " 2.1: Began Tran OK. " ;
	          List<Collaboration> rows=  (ArrayList<Collaboration>) sessionObj.createQuery("from Collaboration").list();
	          for( Collaboration row:rows) {
	        	  JsonObject jsonObject = new JsonObject();
	        	  jsonObject.put("id", row.getCode());
	        	  jsonObject.put("name", row.getName());
	        	  Poductlist.add(jsonObject);
	          }
	          erMsg += " 2.2: Save OK. " ;
	          sessionObj.getTransaction().commit();
	          erMsg = " 2.3 :GEnquiry save Successfully" ;
	      } catch(HibernateException hibernateEx) {
              System.out.println("\n hibernateEx" + erMsg+" "+ "\n....Transaction Is Being Rolled Back" + hibernateEx);
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	      }catch (Exception e) {
	          System.out.println("\n Exception :"+erMsg +"\n"+e );
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
		}
		return Poductlist;
	}
	
	public static JsonArray getProductList(String erMsg) {
		Transaction transaction = null;
		JsonArray demoList= new JsonArray();
		erMsg = " Step 2: HDAO start " ;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	          erMsg += " 2.1: Began Tran OK. " ;
	          ArrayList<ProductDemo> rows=  (ArrayList<ProductDemo>) sessionObj.createQuery("from ProductDemo").list();
	          for( ProductDemo row:rows) {
	        	  JsonObject jsonObject = new JsonObject();
	        	  jsonObject.put("id", row.getCode());
	        	  jsonObject.put("name", row.getName());
	        	  demoList.add(jsonObject);
	          }
	          erMsg += " 2.2: Save OK. " ;
	          sessionObj.getTransaction().commit();
	          erMsg = " 2.3 :GEnquiry save Successfully" ;
	      } catch(HibernateException hibernateEx) {
              System.out.println("\n hibernateEx" + erMsg+" "+ "\n....Transaction Is Being Rolled Back" + hibernateEx);
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	      }catch (Exception e) {
	          System.out.println("\n Exception :"+erMsg +"\n"+e );
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
		}
		return demoList;
	}

}
