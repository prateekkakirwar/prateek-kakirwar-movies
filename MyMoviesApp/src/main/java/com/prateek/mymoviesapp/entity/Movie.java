package com.prateek.mymoviesapp.entity;

import java.util.Date;

/**
 * A generic Movie
 * @author Prateek
 *
 */

public interface Movie {
	
	long getId();
	String getMovieName();
	Date getReleaseDate();
	String getGenre();
	int getRating();
}
