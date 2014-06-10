package com.prateek.mymoviesapp.entity.impl;

import com.prateek.mymoviesapp.entity.Movie;

public class GenericMovie implements Movie {
	
	private long id;
	private String movieName;

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}


	public GenericMovie(long id, String movieName) {
		super();
		this.id = id;
		this.movieName = movieName;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String getMovieName() {
		// TODO Auto-generated method stub
		return movieName;
	}
	
	

}
