package com.rao.System.MASItem;

import java.sql.SQLException;
import java.sql.Types;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOItem {
	
	public static JsonArray ItemSearch(ItemModel ItModel)  {
		JsonArray workType= new JsonArray();
		String erMsg= "Step 3 DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ItemInfoSearch](?,?,?,?)}");
			ComVar.myStat.setString(1,  ItModel.getRwaRegNo());
			ComVar.myStat.setString(2,  ItModel.getICode());
			ComVar.myStat.setString(3,  ItModel.getIName());
			ComVar.myStat.registerOutParameter(4, Types.NVARCHAR);
			erMsg+=" 3.2  SP Param OK";
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute Successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
				System.out.println(erMsg + " " + "No Recod Found [db]");
		    	return workType	;
		    }	
			erMsg += " 3.4 : SP Data ArrayList";
			while (ComVar.prst.next()) {
				JsonObject ItemList= new JsonObject();
				ItemList.put("Code",ComVar.prst.getString("ItemCode"));
				ItemList.put("Name",ComVar.prst.getString("ItemName"));
				ItemList.put("MinLevel",ComVar.prst.getString("MinLevel"));
				ItemList.put("MaxLevel",ComVar.prst.getString("MaxLevel"));
				ItemList.put("ReOrderLevel",ComVar.prst.getString("ReorderLevel"));
				workType.add(ItemList);
			}
			System.out.println("Item ArrayList :" + workType);
			System.out.println("\n"+erMsg);
			
		}catch(SQLException e) {
			erMsg += "Step 3.5 : catch Sql Exception retriving [sp data]";
			System.out.println("\nerMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.5 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return workType;
	}

}
