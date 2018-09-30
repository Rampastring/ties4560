package com.ties4560.task3;

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
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
}	