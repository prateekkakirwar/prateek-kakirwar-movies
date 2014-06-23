package com.prateek.mymoviesapp.service;

import java.util.Date;
import java.util.List;


import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.Theatre;




public interface TheatreService {
	
	Theatre addTheatre(Theatre theatre);

	Theatre getTheatre(long theatreId);

    List<Theatre> getTheatres(String theatreName, String zipCode, String cityName, String stateName);

}
