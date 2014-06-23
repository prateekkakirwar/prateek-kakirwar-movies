package com.prateek.mymoviesapp.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;

/**
 * Return HTTP 409 with response body 
 * 
 * @author pkakirwar
 *
 */
@Provider
@Component

public class MyMoviesAppExceptionMapper implements ExceptionMapper<MyMoviesAppException> {
	
	@Override
	public Response toResponse(MyMoviesAppException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}

}
