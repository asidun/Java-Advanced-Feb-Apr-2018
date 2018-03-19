package com.flowergarden.run;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.db.BouquetDAO;
import com.flowergarden.exception.BouquetException;
import com.flowergarden.exception.FlowerException;
import com.flowergarden.exception.FlowerNotFoundException;

public class RunDb {
	public static void main(String[] args) throws SQLException, IOException, BouquetException, FlowerNotFoundException, FlowerException  {
		int bouquetId = 1;
		RunDb runDb = new RunDb();
		
		File file = new File("flowergarden.db");
		String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
		System.out.println(url);
		Connection conn = DriverManager.getConnection(url);
		
		MarriedBouquet marriedBouquet = runDb.getMarriedBouquet(bouquetId, conn);
		
		System.out.println(marriedBouquet.getPrice());
		
//		PreparedStatement pstmt = conn.prepareStatement("select * from bouquet where name = ?");		
//		String marriedBouquetName = "married";
//		
//		pstmt.setString(1, marriedBouquetName);
//		ResultSet result = pstmt.executeQuery();
//		System.out.println(result);
		
//		Statement stmt = conn.createStatement();
//		ResultSet rst = stmt.executeQuery("select * from flower");
//		
//		while (rst.next()) {			
//			System.out.print(rst.getInt("id") + " ");
//			System.out.print(rst.getString("name") + " ");
//			System.out.print(rst.getInt("spike") + " ");
//			System.out.print(rst.getInt("petals") + " ");
//			System.out.print(rst.getInt("freshness") + " ");
//			System.out.println();
//		}
		
//		CallableStatement prep = conn.prepareCall("sql");
//		prep.execute();
		
		conn.close();
		
		
	}

	MarriedBouquet getMarriedBouquet(int bouquetId, Connection conn) throws BouquetException, FlowerNotFoundException, FlowerException {
		BouquetDAO bouquetDAO = new BouquetDAO(conn);
		MarriedBouquet marriedBouquet = bouquetDAO.getMarriedBouquet(bouquetId);
		return marriedBouquet;
	}

}
