package com.ties4560.task4;

import java.util.HashMap;

import javax.inject.Singleton;
import javax.ws.rs.Path;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import beans.Credential;

@Path("credentials")
@Singleton
public class CredentialResource {
	private HashMap<String, Credential> credMap = new HashMap<String, Credential>();
	
	/**
	 * @param username username
	 * @return response
	 */
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("username") String username) {
		Credential cred = credMap.get(username);
		
		if (cred == null ) {
			throw new DataNotFoundException("User with name "+ username +" was not found.");
		}
		
		return Response.status(Status.OK).entity(cred).build();
	}
	
	/**
	 * @param cred created user
	 * @return response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Credential cred) {
		String name = cred.getName();
		
		if(credMap.containsKey(name))
			throw new ItemException("User with name" + name + "already exists");
		
		credMap.put(name, cred);
		
		return Response.status(Status.CREATED).entity(cred).build();
	}
	
	@DELETE
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOrder(@PathParam("username") String username) {
		Credential cred  = credMap.remove(username);
		
		if (cred == null)
			throw new DataNotFoundException("User with name "+ username +" was not found. Cannot delete the order.");
		
		return Response.status(Status.CREATED).entity(cred).build();
	}
	
	
}
