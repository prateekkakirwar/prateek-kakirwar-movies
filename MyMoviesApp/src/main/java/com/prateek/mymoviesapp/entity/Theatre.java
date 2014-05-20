package com.prateek.mymoviesapp.entity;

import java.util.ArrayList;
import java.util.List;

public interface Theatre {
	
	long getId();
	
	String getMovieName();
	
	List<Show> list = new ArrayList<Show>();

}
