package com.prateek.mymoviesapp.repository;

import java.util.Date;
import java.util.List;

import com.prateek.mymoviesapp.entity.Movie;


public interface MovieRepository {
	
	long addMovie(Movie movie);
	
	Movie getMovie(long movieId);
	
	List<Movie> search(String movieName, Date releaseDate, int rating, String genre);

}
