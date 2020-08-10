package com.rao.System.PO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.DeserializationException;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;


public class Tjson {
    public static int ctr=0;

	public static void main(String[] args) {
		System.out.println("Step 1. Create abc.json file");
		 filecreate();
//		 filereadWrite();
		 readJsonFile();
	}

	private static void filecreate() {
		JsonArray Jarry = new JsonArray();

		JsonObject AddressDetail = new JsonObject();
		AddressDetail.put("Apt", "prime city");
		AddressDetail.put("City", "Bangalore");
		AddressDetail.put("State", "Karnataka");
		AddressDetail.put("Country", "India");
		AddressDetail.put("Pin", "560100");
		
		JsonObject Pdetail = new JsonObject();
		Pdetail.put("Name", "Prashant");
		Pdetail.put("MName", "Kumar");
		Pdetail.put("LName", "Rai");
		Pdetail.put("Age", "21");


		JsonObject Personal = new JsonObject();

		Personal.put("Personal",Pdetail );
		Personal.put("Address",AddressDetail );

		JsonObject SNO = new JsonObject();
		SNO.put("SNo1", Personal);
		
		Jarry.add(SNO);
		System.out.println(SNO);

		JsonObject Pdetail1 = new JsonObject();
		Pdetail1.put("Name", "MK");
		Pdetail1.put("MName", "SINGH");
		Pdetail1.put("LName", "Rai");
		Pdetail1.put("Age", "29");
		
		JsonObject AddressDetail1 = new JsonObject();
		AddressDetail1.put("Apt", "A Block");
		AddressDetail1.put("city", "Delhi");
		AddressDetail1.put("State", "New Delhi");
		AddressDetail1.put("Country", "India");
		AddressDetail1.put("Pin", "110070");

		JsonObject Personal1 = new JsonObject();
		
		Personal1.put("Personal",Pdetail1 );
		Personal1.put("Address",AddressDetail1 );

		JsonObject SNO1 = new JsonObject();
		SNO1.put("SNo2", Personal1);
		
		Jarry.add(SNO1);
		System.out.println("JsonArry :" +Jarry);

		try {
			FileWriter fWiter = new FileWriter("D:/ABC.Json");
			fWiter.write(Jarry.toJson());
			fWiter.flush();
			fWiter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void filereadWrite() {
		
		try {
			FileReader fReader = new FileReader("D:/abc.json");
			JsonArray PersonalInfo = (JsonArray) Jsoner.deserialize(fReader);
			fReader.close();
			
			System.out.println(PersonalInfo);
			System.out.println("knrai");
			
			 //Iterating the contents of the array
	         Iterator<Object> iterator = PersonalInfo.iterator();
	         
	 		JsonObject Pdetail1 = new JsonObject();
			Pdetail1.put("Name", "Mrs");
			Pdetail1.put("MName", "Gupta");
			Pdetail1.put("LName", "singh");
			Pdetail1.put("Age", "39");
			
			JsonObject AddressDetail1 = new JsonObject();
			AddressDetail1.put("Apt", "cBlock");
			AddressDetail1.put("city", "New Delhi");
			AddressDetail1.put("State", "Vasant Kunj");
			AddressDetail1.put("Country", "India");
			AddressDetail1.put("Pin", "110070");

			JsonObject Peronal1 = new JsonObject();
			
			Peronal1.put("Personal",Pdetail1 );
			Peronal1.put("Address",AddressDetail1 );
			PersonalInfo.add(Peronal1);	         
	        System.out.println("PersonalInfo" + PersonalInfo); 
			try {
				FileWriter fWiter = new FileWriter("D:/ABC.Json");
				fWiter.write(PersonalInfo.toJson());
				fWiter.flush();
				fWiter.close();
			} catch (FileNotFoundException e) {
			     System.out.println(e);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (DeserializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void readJsonFile() {
		try{
			FileReader fRead = new FileReader("D:/ABC.Json");
			JsonArray invList = (JsonArray) Jsoner.deserialize(fRead);
			invList.forEach(emp-> parseInvJsonArray( (JsonObject) emp));
			
		//	readJsonAarrayKey( invList);
			traverseJsonAarrayKey(invList);

		}catch(Exception e){
			System.out.println("Error :" + e);
		}
	}
	
	private static void parseInvJsonArray(JsonObject inv) {
		ctr=ctr+1;
		try {
			JsonObject sno =  (JsonObject) inv.get("SNo" +Integer.toString(ctr));
			if(!sno.equals(null)) {
				JsonObject PersObj =  (JsonObject) sno.get("Personal");
				JsonObject AddsObj =  (JsonObject) sno.get("Address");
				System.out.println("Name :"  + PersObj.get("Name"));
				System.out.println("LName :" + PersObj.get("LName"));
				System.out.println("MName :" + PersObj.get("MName"));
				System.out.println("Age  :"   + PersObj.get("Age"));
				System.out.println("Apt  :"   + AddsObj.get("Apt"));
				System.out.println("City :"  + AddsObj.get("City"));
				System.out.println("State:" + AddsObj.get("State"));
			}
		}catch(Exception e) {
			System.out.println("CTr :" +ctr);	
		}
	}

	private static void knparseInvJsonArray(JsonObject inv) {
		
		JsonObject PersObj =  (JsonObject) inv.get("Personal");
		JsonObject AddsObj =  (JsonObject) inv.get("Address");
		System.out.println("Name :"  + PersObj.get("Name"));
		System.out.println("LName :" + PersObj.get("LName"));
		System.out.println("MName :" + PersObj.get("MName"));
		System.out.println("Age  :"   + PersObj.get("Age"));
		System.out.println("Apt  :"   + AddsObj.get("Apt"));
		System.out.println("City :"  + AddsObj.get("City"));
		System.out.println("State:" + AddsObj.get("State"));
		
	}
	
// function to read json array using while loop
	private static void readJsonAarrayKey(JsonArray persInfo) {
		 Iterator<Object> arrayList = persInfo.iterator();
		 System.out.println("Shika Idle");
	     while (arrayList.hasNext()) {
	         JsonObject jsonObject = (JsonObject) arrayList.next();

	         for (String key : jsonObject.keySet()) {
        		 System.out.println("kuta dagi :" +key );
	        	 
	        	 if (key.equals("SNo1")) {
	        		 System.out.println("pila dagi" );
	        		 jsonObject.remove(key);
	        		 break;
	        		 
	        	 }
	             System.out.println(key + ":" + jsonObject.get(key));
	         }
	     }
         System.out.println("revise Array :" + persInfo);
         persInfo.forEach(emp-> parseInvJsonArray( (JsonObject) emp));
			
	}

	// function to read json array using while loop
		private static void traverseJsonAarrayKey(JsonArray persInfo) {
			 Iterator<Object> arrayList = persInfo.iterator();
			 System.out.println("Shika Idle");
		     while (arrayList.hasNext()) {
		         JsonObject jsonObject = (JsonObject) arrayList.next();

		         for (String key : jsonObject.keySet()) {
	        		 System.out.println("kuta dagi :" +key );
		        	 
		             System.out.println("key:"+ key + ": value -:" + jsonObject.get(key));
		         }
		     }
	         System.out.println("revise Array :" + persInfo);
	         persInfo.forEach(emp-> parseInvJsonArray( (JsonObject) emp));
				
		}


}
/*
 * $("#POBTN01").click(function(){ fDate = $("#FromDate").val(); tDate =
 * $("#ToDate").val(); var PONo=$("#PONo").val(); var request =$.ajax({
 * type:'POST', data:{PONO:PONo, fromDate:fDate,toDate:tDate, Action:"POList"},
 * dataType: 'json', url:'../POSummary', success:function(result){ if
 * ($("#ActionType").val()=='2'){ alert("wah kamal zero one");
 * POListForEdit(result); }else{ alert("wah kamal zero");
 * tableItemsView(result); } } });
 * 
 * });// eof submit
 */