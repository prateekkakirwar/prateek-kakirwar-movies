package com.prateek.mymoviesapp.repository;

import com.prateek.mymoviesapp.entity.Theatre;

import java.util.Date;
import java.util.List;

public interface TheatreRepository {

	long addTheatre(Theatre theatre);
	
	Theatre getTheatre(long theatreId);

    List<Theatre> search(String theatreName, String zipCode, String cityName, String stateName);
	
}
