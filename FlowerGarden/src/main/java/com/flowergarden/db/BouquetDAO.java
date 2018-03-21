package com.flowergarden.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.exception.BouquetException;
import com.flowergarden.exception.FlowerException;
import com.flowergarden.exception.FlowerNotFoundException;
import com.flowergarden.flowers.GeneralFlower;

public class BouquetDAO {

	private Connection conn;
	private FlowerDAO flowerDAO;

	public BouquetDAO(DriverManagerDataSource dataSource) throws BouquetException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new BouquetException("DB connection error.");
		}
	}
	
	public void setFlowerDAO(FlowerDAO fDAO){
		flowerDAO = fDAO;
	}

	public MarriedBouquet getMarriedBouquet(int bouquetId) throws BouquetException, 
	FlowerNotFoundException, FlowerException {
		MarriedBouquet marrideBouqet = new MarriedBouquet();
		int flowerId;
		
		try (PreparedStatement pstmt = 
				conn.prepareStatement("select * from flower where bouquet_id = ?")) {
			

			pstmt.setInt(1, bouquetId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				flowerId = rs.getInt("id");
				GeneralFlower generalFlower = flowerDAO.getFlowerById(flowerId);
				marrideBouqet.addFlower(generalFlower);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BouquetException("DB connection error.");
		} 
		return marrideBouqet;
	}

}
