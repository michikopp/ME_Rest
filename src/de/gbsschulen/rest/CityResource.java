package de.gbsschulen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/world")
public class CityResource {

    private CityService cityService = new CityService();

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City getCity(@PathParam("id") int id) {
        return cityService.getCity(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> getAllCitys() {
        return cityService.getAllCity();
    }
}
