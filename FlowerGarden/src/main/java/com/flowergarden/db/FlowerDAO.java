package com.flowergarden.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.flowergarden.exception.BouquetException;
import com.flowergarden.exception.FlowerException;
import com.flowergarden.exception.FlowerNotFoundException;
import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.flowers.Tulip;
import com.flowergarden.properties.FreshnessInteger;

public class FlowerDAO {
	
	private Connection conn;

	public FlowerDAO(DriverManagerDataSource dataSource) throws FlowerException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new FlowerException("DB connection error.");
		}
	}
	
	GeneralFlower getFlowerById(int id) throws FlowerNotFoundException, FlowerException{
		GeneralFlower flower = null;
		String flowerName = null;
		
		try (PreparedStatement pstmt = 
				conn.prepareStatement("select * from flower where id = ?")) {
			

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {	
				flowerName = rs.getString("name");
				switch (flowerName) {
				case "rose":
					flower = new Rose(rs.getBoolean("spike"), rs.getInt("lenght"), rs.getFloat("price"), 
							new FreshnessInteger(rs.getInt("freshness")));
					break;
				case "chamomile":
					flower = new Chamomile(rs.getInt("petals"), rs.getInt("lenght"), rs.getFloat("price"), 
							new FreshnessInteger(rs.getInt("freshness")));
					break;
				case "tulip":
					flower = new Tulip();
					break;
				default:
					throw new FlowerNotFoundException("Unknown flower " + flowerName+ " from DB");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FlowerException("DB connection error.");
		}
		
		return flower;		
	}
	
}
