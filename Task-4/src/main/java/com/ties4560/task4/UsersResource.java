/**
 * 
 */
package com.ties4560.task4;

import java.util.HashMap;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import beans.Credential;

/**
 * @author Janita
 * @version 30.9.2018
 *
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@PermitAll
public class UsersResource {
	
	private static HashMap<String, Credential> credentials = new HashMap<String, Credential>();
	
	@Path("/authenticate")
	@POST
	public Response authenticateUser(String token) {
		if (credentials.get(token) != null) {
			Response.status(Status.OK).entity(credentials.get(token)).build();
		}
		return Response.status(Status.NOT_FOUND).entity(token).build();
	}
	
	@POST
	public Response createUser(Credential newCredential) {
		String token = createToken(newCredential);
		if (token != null && !token.isEmpty()) {
			credentials.put(token, newCredential);
		} else {
			return Response.status(Status.NOT_ACCEPTABLE).entity(newCredential).build();
		}
		
		return Response.status(Status.CREATED).entity(newCredential).build();
	}

	private String createToken(Credential credential) {
		if (!credential.getName().isEmpty() && !credential.getPassword().isEmpty()) {
			return credential.getName() + UUID.randomUUID().toString();
		}
		return null;
	}
	
	@GET
	@Path("/{username}")
	@RolesAllowed("admin")
	public Response getUser(@PathParam("username") String username) {
		for (Credential cred : credentials.values()) {
			if (cred.getName().equals(username)) {
				return Response.status(Status.OK).entity(cred).build();
			}
		}
		throw new DataNotFoundException("User with name "+ username +" was not found.");
	}
	
	@DELETE
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("username") String username) {
		for (Credential cred : credentials.values()) {
			if (cred.getName().equals(username)) {
				credentials.values().remove(cred);
				return Response.status(Status.OK).entity(cred).build();
			}
		}
		
		throw new DataNotFoundException("User with name "+ username +" was not found. Cannot delete the user.");
	}

}
