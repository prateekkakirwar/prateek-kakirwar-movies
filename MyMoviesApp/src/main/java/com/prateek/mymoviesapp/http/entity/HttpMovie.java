package com.prateek.mymoviesapp.http.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.prateek.mymoviesapp.entity.Movie;



/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author pkakirwar
 *
 */

@XmlRootElement(name = "movie")
public class HttpMovie {

	@XmlElement
	public long id;

	@XmlElement
	public String movieName;

	@XmlElement
	public Date releaseDate;

	@XmlElement
	public int rating;
	
	@XmlElement
	public String genre;

	//required by framework
	protected HttpMovie() {}

	public HttpMovie(Movie movie) {
		this.id=movie.getId();
		this.movieName=movie.getMovieName();
		this.releaseDate=movie.getReleaseDate();
		this.rating=movie.getRating();
		this.genre=movie.getGenre();
	}

}
