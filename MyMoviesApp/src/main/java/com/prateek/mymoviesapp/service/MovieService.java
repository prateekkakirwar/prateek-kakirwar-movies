package com.prateek.mymoviesapp.service;

import java.util.Date;
import java.util.List;

import com.prateek.mymoviesapp.entity.Movie;

public interface MovieService {
	
	Movie addMovie(Movie movie);
	
	Movie getMovie(long movieId);
	
	List<Movie> getMovies(String movieName, Date releaseDate, int rating, String genre);

}
