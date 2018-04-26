package com.qa.business.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONutil;

public class MovieDBRepository implements IMovieRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	
	@Inject
	private JSONutil util;
	

	
	public String getAllMovies() {
			LOGGER.info("MovieDBRepository getAllMovies");
			Query query = manager.createQuery("Select m FROM Movie m");
			Collection<Movie> movies = (Collection<Movie>) query.getResultList();
			return util.getJSONForObject(movies);
	}

	
	//@Override
	public String getAMovie (Long id) {
	Movie aMovie = manager.find(Movie.class, id);
		if (aMovie != null) 
		{
			return util.getJSONForObject(aMovie); 
		}
		else {
			return "{\"message\":\"Movie not found\"}";
		}
	}
	
	//@Override
	@Transactional(REQUIRED)
		public String createMovie (String movieJson) {
		Movie aMovie = util.getObjectForJSON(movieJson, Movie.class);
		manager.persist(aMovie);
		return "{\"message\":\"Movie created\"}";
		}
	
	//@Override
	@Transactional(REQUIRED)
    public String updateMovie (String movieToUpdate, Long id) {
    	Movie updatedMovie = util.getObjectForJSON(movieToUpdate, Movie.class);
		Movie movieListed = getAMovie(id);
		if (movieToUpdate != null) {
			movieListed = updatedMovie;
        manager.merge(movieListed);
		}
        return "{\"Movie updated\"}";
    }
	
	 //@Override
		@Transactional(REQUIRED)
	    public String deleteMovie(Long id) {
	        manager.remove(manager.getReference(Movie.class, id));
	        return "{\"Movie deleted\"}";
	    }

}
