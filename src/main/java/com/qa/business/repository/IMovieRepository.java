package com.qa.business.repository;

public interface IMovieRepository {
	
	String getAllMovies();
	
	String getAMovie(Long id);
	
	String createMovie(String movieJson);
	
	String updateMovie(Long id, String movie);
	
	String deleteMovie(Long id);
	
}
