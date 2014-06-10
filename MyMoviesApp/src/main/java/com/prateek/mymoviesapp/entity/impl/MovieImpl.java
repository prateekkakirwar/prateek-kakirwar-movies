package com.prateek.mymoviesapp.entity.impl;

import java.util.Date;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prateek.mymoviesapp.entity.Movie;

@Entity
@Table(name="movie")
public class MovieImpl implements Movie {
	@Id //primary key
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // vendor specific code 	
	private long id;
	
	@Column(name="moviename")
	private String movieName;
	
	@Column(name="releasedate")
	private Date releaseDate;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="genre")
	private String genre;
	
	public MovieImpl(long id, String movieName) {
		super();
		this.id = id;
		this.movieName = movieName;
	}
	

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String getMovieName() {
		// TODO Auto-generated method stub
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	@Override
	public Date getReleaseDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	

	@Override
	public int getRating() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}


	@Override
	public String getGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "MovieImpl [id=" + id + ", movieName=" + movieName
				+ ", releaseDate=" + releaseDate + ", rating=" + rating
				+ ", genre=" + genre + "]";
	}

    
	

}
