package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IMovieService;

@Path("movie")
public class MovieEndPoint {
	
	@Inject
	private IMovieService service;
	
	@GET  //postman calls obj layer repo db entity manag db conv tabl obj conv movie jsn interoper layer 
	@Path("/json")
	@Produces ({"application/json"})
	public String GetAllMovies() {
		return service.getAllMovies();

	}
	
	@GET  //postman calls obj layer repo db entity manag db conv tabl obj conv movie jsn interoper layer 
	@Path("/json/{id}")
	@Produces ({"application/json"})
	public String GetAMovie(@PathParam("id")Long id) {
		return service.getAMovie(id);

	}
	
	@POST  
	@Path("/json")
	@Produces ({"application/json"})
	public String createMovie(String jsonString) {
		return service.createMovie(jsonString);

	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String updateMovie(@PathParam("id")Long id, String movie) {
		return service.updateMovie(id, movie);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteMovie(@PathParam("id")Long id) {
		return service.deleteMovie(id);

	}
}
