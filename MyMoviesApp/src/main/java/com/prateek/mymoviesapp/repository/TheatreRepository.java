package com.prateek.mymoviesapp.repository;

import com.prateek.mymoviesapp.entity.Theatre;

public interface TheatreRepository {

	long addTheatre(Theatre theatre);
	
	Theatre getTheatre(long theatreId);
	
}
