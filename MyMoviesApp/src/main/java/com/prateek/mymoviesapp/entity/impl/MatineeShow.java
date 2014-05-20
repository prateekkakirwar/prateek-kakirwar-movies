package com.prateek.mymoviesapp.entity.impl;

import java.util.Date;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Show;

public class MatineeShow implements Show {
	
	private long id;
	private Movie movie;
	private Date movieTime;
	
	

	public MatineeShow(long id, Movie movie, Date movieTime) {
		super();
		this.id = id;
		this.movie = movie;
		this.movieTime = movieTime;
	}

	@Override	
	public Movie getMovie() {
		return movie;
	}

	public Date getMovieTime() {
		return movieTime;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setMovieTime(Date movieTime) {
		this.movieTime = movieTime;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	

}
