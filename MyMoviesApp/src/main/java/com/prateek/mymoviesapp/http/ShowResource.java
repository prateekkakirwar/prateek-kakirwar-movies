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

import com.prateek.mymoviesapp.entity.Show;
import com.prateek.mymoviesapp.entity.impl.ShowImpl;
import com.prateek.mymoviesapp.http.entity.HttpShow;
import com.prateek.mymoviesapp.service.ShowService;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;



@Path("/shows")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ShowResource {
	
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowService showService;
	
	@POST
	@Path("/")
	public Response createShow(HttpShow newShow){
		Show showToCreate = convert(newShow);
		Show addedShow = showService.addShow(showToCreate);
		return Response.status(Status.CREATED).header("Location", "/shows/"+addedShow.getId()).entity(new HttpShow(addedShow)).build();
	}	
	
	@GET
	@Path("/{showId}")	
	public HttpShow getShowById(@PathParam("showId") long showId){
		logger.info("getting show by id:"+showId);
		Show show = showService.getShow(showId);	
		return new HttpShow(show);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="shows")
	public List<HttpShow> getShowSearch(@QueryParam("showTime") Date showTime, @QueryParam("movieName") String movieName, @QueryParam("theatreName") String theatreName) throws MyMoviesAppException{
		List<Show> found = showService.getShows(showTime, movieName, theatreName);
		List<HttpShow> returnList = new ArrayList<HttpShow>(found.size());
		for(Show show:found){
			returnList.add(new HttpShow(show));
		}
		return returnList;
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newShow
	 * @return
	 */
	private Show convert(HttpShow httpShow) {
		ShowImpl show = new ShowImpl();
		show.setShowTime(httpShow.showTime);
		show.setMovie(httpShow.movie);
		show.setTheatre(httpShow.theatre);
		return show;
	}		

}
