package com.prateek.mymoviesapp.entity;

import java.util.ArrayList;
import java.util.List;

public interface Theatre {
	
	
	long getId();

	String getTheatreName();
	
	String getZipCode();
	
	String getCityName();
	
	String getStateName();
	
	List<Show> list = new ArrayList<Show>();
}
