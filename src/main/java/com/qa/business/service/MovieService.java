package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMovieRepository;

public class MovieService implements IMovieService {

	@Inject
	private IMovieRepository repo;
	
	
	//@Override
	public String getAllMovies() {
		return repo.getAllMovies();
	}
	
	//@Override
	public String getAMovie(Long id) {
		return repo.getAMovie(id);
	}
	
	//@Override
	public String createMovie(String jsonString) {
			return repo.createMovie(jsonString);
		}
	
	//@Override
	public String updateMovie(Long id, String movie) {
			return repo.updateMovie(id, movie);
		}

	//@Override
	public String deleteMovie(Long id) {
		public String deleteMovie(Long id) {
			return repo.deleteMovie(id);
	}
		
	}
}
