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
 
@GET
 @Path("/get_next_ad_id")
 @Produces("text/plain")
 public Response get_next_ad_id() 
 {           
	String str_id = null;
	try { 
		str_id = model.get_next_ad_id();
	}
	catch (Exception e) {
		return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	
    }
	return Response.ok(str_id).build();           
 }
	
@PUT
 @Path("/add_ad")
 @Consumes("application/json")
 public void add_ad(String user_data)
 {           
	Jsonb jsonb = JsonbBuilder.create();
	EAd ad = new EAd();
	ad = jsonb.fromJson(user_data, EAd.class);
	try { 
		model.add_ad(ad);
	}
	catch (Exception e) {}     
 }
	
@GET
 @Path("/get_next_user_id")
 @Produces("text/plain")
 public Response get_next_user_id() 
 {           
	String str_id = null;
	try { 
		str_id = model.get_next_user_id();
	}
	catch (Exception e) {
		return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	
    }
	return Response.ok(str_id).build();           
 }
	
@GET
 @Path("/auth")
 @Produces("text/plain")
 public Response auth(@QueryParam("user") String user_data) 
 {           
	String check_auth;
	Jsonb jsonb = JsonbBuilder.create();
	EUser user = new EUser();
	user = jsonb.fromJson(user_data, EUser.class);
	try { 
		check_auth = model.auth(user);
	}
	catch (Exception e) {
		return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	
    }
	return Response.ok(check_auth).build();           
 }

@PUT
 @Path("/registration_client")
 @Consumes("application/json")
 public void registration_client(String user_data)
 {           
	Jsonb jsonb = JsonbBuilder.create();
	EClient client = new EClient();
	client = jsonb.fromJson(user_data, EClient.class);
	try { 
		model.registration_client(client);
	}
	catch (Exception e) {}     
 }
  
 @PUT
 @Path("/registration_user")
 @Consumes("application/json")
 public void registration_user(String user_data)
 {           
	Jsonb jsonb = JsonbBuilder.create();
	EUser user = new EUser();
	user = jsonb.fromJson(user_data, EUser.class);
	try { 
		model.registration_user(user);
	}
	catch (Exception e) {}     
 }

}
