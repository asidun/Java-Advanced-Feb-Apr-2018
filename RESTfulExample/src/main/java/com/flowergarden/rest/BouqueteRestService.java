package com.flowergarden.rest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.db.BouquetDAO;
import com.flowergarden.db.FlowerDAO;
import com.flowergarden.exception.BouquetException;
import com.flowergarden.exception.FlowerException;
import com.flowergarden.exception.FlowerNotFoundException;
import com.flowergarden.flowers.Rose;

@Path("/boquete")
public class BouqueteRestService {
	Connection conn;
	
	public BouqueteRestService() throws IOException, SQLException {
		File file = new File("flowergarden.db");
		String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
		conn = DriverManager.getConnection(url);
	}
	
//	@GET 
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{id}") 
//	public MarriedBouquet getBouqueteById(@PathParam("id") int bouqueteId) throws 
//	BouquetException, FlowerNotFoundException, FlowerException {
//		BouquetDAO bouqueteDAO = new BouquetDAO(conn);		
//		bouqueteDAO.setFlowerDAO(new FlowerDAO(conn));
//		return bouqueteDAO.getMarriedBouquet(bouqueteId);		
//	}
}
