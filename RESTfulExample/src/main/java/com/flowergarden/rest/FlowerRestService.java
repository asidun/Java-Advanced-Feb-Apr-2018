package com.flowergarden.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

@Path("/flower")
public class FlowerRestService {

	@GET
	public Response getStatus() {
		return Response.status(200).entity(" FlowerRestService is ok").build();
	}

	@GET
	@Path("/rose")
	@Produces(MediaType.APPLICATION_XML)
	public Rose getRose() {
		Rose rose = new Rose(true, 10, 22, new FreshnessInteger(1));
		return rose;
	}
	
	@GET
	@Path("/chamomile")
	@Produces(MediaType.APPLICATION_XML)
	public Chamomile getChamomile() {
		Chamomile chamomile = new Chamomile(5, 10, 22, new FreshnessInteger(1));
		return chamomile;
	}
	
	@GET 
	@Path("/user/{name}") 
	public Response getUserByName(@PathParam("name") String name) { 
		return Response.status(200) .entity("getUserByName is called, name : " + name).build(); 
	}

}
