package com.qa.business.service;

public interface IMovieService {
	
	String getAllMovies();
	
	String getAMovie(Long id);

	String createMovie(String movieJson);
	
	String updateMovie(Long id, String movie);

	String deleteMovie(Long id);
}
