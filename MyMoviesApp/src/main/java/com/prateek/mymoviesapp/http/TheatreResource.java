package com.prateek.mymoviesapp.http;

import com.prateek.mymoviesapp.entity.Theatre;
import com.prateek.mymoviesapp.entity.impl.TheatreImpl;
import com.prateek.mymoviesapp.http.entity.HttpTheatre;
import com.prateek.mymoviesapp.service.TheatreService;
import com.prateek.mymoviesapp.service.exception.MyMoviesAppException;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkakirwar on 6/22/14.
 */

@Path("/theatres")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheatreResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TheatreService theatreService;

    @POST
    @Path("/")
    public Response createTheatre(HttpTheatre newTheatre){
        Theatre theatreToCreate = convert(newTheatre);
        Theatre addedTheatre = theatreService.addTheatre(theatreToCreate);
        return Response.status(Response.Status.CREATED).header("Location", "/theatres/"+addedTheatre.getId()).entity(new HttpTheatre(addedTheatre)).build();
    }

    @GET
    @Path("/{theatreId}")
    public HttpTheatre getTheatreById(@PathParam("theatreId") long theatreId){
        logger.info("getting theatre by id:"+theatreId);
        Theatre theatre = theatreService.getTheatre(theatreId);
        return new HttpTheatre(theatre);
    }

    @GET
    @Path("/")
    @Wrapped(element="theatres")
    public List<HttpTheatre> getTheatreSearch(@QueryParam("theatreName") String theatreName, @QueryParam("zipCode") String zipCode, @QueryParam("cityName") String cityName, @QueryParam("stateName") String stateName) throws MyMoviesAppException {
        List<Theatre> found = theatreService.getTheatres(theatreName, zipCode, cityName,stateName);
        List<HttpTheatre> returnList = new ArrayList<HttpTheatre>(found.size());
        for(Theatre theatre:found){
            returnList.add(new HttpTheatre(theatre));
        }
        return returnList;
    }

    /**
     * Not pushing this into business layer. Could be a util as well
     * @param newTheatre
     * @return
     */
    private Theatre convert(HttpTheatre httpTheatre) {
        TheatreImpl theatre = new TheatreImpl();
        theatre.setTheatreName(httpTheatre.theatreName);
        theatre.setZipCode(httpTheatre.zipcode);
        theatre.setCityName(httpTheatre.cityname);
        theatre.setStateName(httpTheatre.statename);
        return theatre;
    }
}
