package com.prateek.mymoviesapp.repository;

import com.prateek.mymoviesapp.entity.Movie;

public interface MovieRepository {
	
	long addMovie(Movie movie);
	
	Movie getMovie(long movieId);

}
