package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.IMovieService;

@Path("movie")
public class MovieEndPoint {
	
	@Inject
	private IMovieService service;
	
	@GET  //postman calls obj layer repo db entity manag db conv tabl obj conv movie jsn interoper layer 
	@Path("json")
	@Produces ({"application/json"})
	public String GetAllMovies() {
		return service.getAllMovies();

	}
}
