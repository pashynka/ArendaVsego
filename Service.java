package rest;

import javax.ws.rs.QueryParam;

import rest.model.entity.EClient;
import rest.model.entity.EUser;
import rest.model.entity.EAd;

import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import javax.ws.rs.core.Response;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

import java.util.List;

import javax.inject.Inject;
import rest.model.IModel;


@Path("/")
public class Service {
 
 @Inject
 IModel model;
 
 @GET
 @Path("/get_ad")
 @Produces("application/json")
 public Response get_ad(@QueryParam("id") String user_data) 
 {           
	EAd ad = new EAd();
	try {
		model.get_ad(ad, user_data);
	}
	catch (Exception e) {
		return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	
    }
	Jsonb jsonb = JsonbBuilder.create();                
	String resultJSON = "";
	try {  		  
		resultJSON = jsonb.toJson(ad);	  	 
	}
	catch (JsonbException e) {
		return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	             
	}	
	catch (Exception e) {
		return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	             
	}    
	return Response.ok(resultJSON).build();           
 }
 
}
