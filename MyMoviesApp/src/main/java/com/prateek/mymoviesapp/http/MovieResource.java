package com.prateek.mymoviesapp.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prateek.mymoviesapp.entity.Movie;
import com.prateek.mymoviesapp.entity.impl.MovieImpl;
import com.prateek.mymoviesapp.http.entity.HttpMovie;
import com.prateek.mymoviesapp.service.MovieService;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;


@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieService movieService;
	
	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie){
		Movie movieToCreate = convert(newMovie);
		Movie addedMovie = movieService.addMovie(movieToCreate);
		return Response.status(Status.CREATED).header("Location", "/movies/"+addedMovie.getId()).entity(new HttpMovie(addedMovie)).build();
	}	
	
	@GET
	@Path("/{movieId}")	
	public HttpMovie getMovieById(@PathParam("movieId") long movieId){
		logger.info("getting movie by id:"+movieId);
		Movie movie = movieService.getMovie(movieId);	
		return new HttpMovie(movie);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="movies")
	public List<HttpMovie> getMovieSearch(@QueryParam("movieName") String movieName, @QueryParam("releaseDate") Date releaseDate, @QueryParam("rating") int rating, @QueryParam("genre") String genre) throws MyMoviesAppException{
		List<Movie> found = movieService.getMovies(movieName, releaseDate, rating, genre);
		List<HttpMovie> returnList = new ArrayList<HttpMovie>(found.size());
		for(Movie movie:found){
			returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newMovie
	 * @return
	 */
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpMovie.movieName);
		movie.setRating(httpMovie.rating);
		movie.setReleaseDate(httpMovie.releaseDate);
		return movie;
	}	

}
