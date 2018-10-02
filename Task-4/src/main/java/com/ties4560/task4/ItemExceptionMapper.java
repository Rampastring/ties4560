package com.ties4560.task4;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Jaro
 * @version 25.9.2018
 *
 */
@Provider
public class ItemExceptionMapper implements ExceptionMapper<ItemException> {
	
	@Override
	public Response toResponse(ItemException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 400, "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
}
