package com.prateek.mymoviesapp.entity.impl;

import java.util.Date;

import com.prateek.mymoviesapp.entity.Movie;

public class MovieImpl implements Movie {
	
	private long id;
	private String movieName;

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}


	public MovieImpl(long id, String movieName) {
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


	@Override
	public Date getReleaseDate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRating() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getGenre() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getMovieRating() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
