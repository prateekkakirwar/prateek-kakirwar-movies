package com.prateek.mymoviesapp.entity;

import java.util.ArrayList;
import java.util.List;

public interface Theatre {
	
	
	long getId();

	String getTheatreName();
	
	String getZipCode();
	
	String getCityName();
	
	String getStateName();
	
	String getMovieName();
	
	List<Show> list = new ArrayList<Show>();
}
