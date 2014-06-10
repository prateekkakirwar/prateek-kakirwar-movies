package com.prateek.mymoviesapp.service;

import com.prateek.mymoviesapp.entity.Movie;

public interface MovieService {
	
	long addMovie(Movie movie);
	
	Movie getMovie(long movieId);

}
