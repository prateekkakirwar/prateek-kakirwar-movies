package com.prateek.mymoviesapp.entity;

import java.util.Date;

public interface Show {
	
	public long getId();
	
	Date getShowTime();
	
	public Movie getMovie();
	
	public Theatre getTheatre();
	
	
}
