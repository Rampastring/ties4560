/**
 * 
 */
package com.ties4560.task4;

import java.util.Iterator;
import java.util.UUID;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.naming.InitialContext;
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

import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;

import beans.Credential;

/**
 * @author Janita, Jaro
 * @version 3.10.2018
 *
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@PermitAll
public class UsersResource {


//	@Path("/authenticate")
//	@POST
//	public Response authenticateUser(String token) {
//		if (credentials.get(token) != null) {
//			Response.status(Status.OK).entity(credentials.get(token)).build();
//		}
//		return Response.status(Status.NOT_FOUND).entity(token).build();
//	}

	@POST
	public Response createUser(Credential newCredential) {
		String token = createToken(newCredential);
		if (token != null && !token.isEmpty()) {
//			credentials.put(token, newCredential);
			try {
				UserDatabase ud = (UserDatabase) new InitialContext().lookup("java:comp/env/UserDatabase");
				User user = ud.createUser(newCredential.getName(), newCredential.getPassword(), token);
				Iterator<Role> roles = ud.getRoles();
				while (roles.hasNext()) {
					Role role = (Role) roles.next();
					if (role.getRolename().equals("user"))
						user.addRole(role);						
				}
				ud.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		try {
			UserDatabase ud = (UserDatabase) new InitialContext().lookup("java:comp/env/UserDatabase");
			Iterator<User> users = ud.getUsers();
			User user = null;
			while (users.hasNext()) {
				user = (User) users.next();
				if (user.getUsername().equals(username)) {
					return Response.status(Status.OK).entity(new Credential(user.getUsername(), user.getPassword())).build();
				}
			}
		} catch (Exception e) {
			throw new DataNotFoundException("User with username " + username + " was not found.");
		}
		throw new DataNotFoundException("User with username " + username + " was not found.");
	}

	@DELETE
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("username") String username) {
		try {
			UserDatabase ud = (UserDatabase) new InitialContext().lookup("java:comp/env/UserDatabase");
			Iterator<User> users = ud.getUsers();
			User user = null;
			while (users.hasNext()) {
				user = (User) users.next();
				if (user.getUsername().equals(username)) {
					ud.removeUser(user);
					ud.save();
					return Response.status(Status.OK).entity(new Credential(user.getUsername(), user.getPassword())).build();
				}
			}
		} catch (Exception e) {
			throw new DataNotFoundException("User with username " + username + " was not found. Cannot delete the user.");
		}
		throw new DataNotFoundException("User with username " + username + " was not found. Cannot delete the user.");
	}
}
