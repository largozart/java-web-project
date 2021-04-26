package com.bivgroup.module.dadataclient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.bivgroup.module.dadataclient.pojo.LocationResult;
import com.bivgroup.module.dadataclient.pojo.Request;

@Path("/")
public class DadataClient {

    private final String authKey = "";
    private final String authSecret = "";

    DaDataService daData = new DaDataService(authKey, authSecret);

    @POST
    @Path("/iplocate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LocationResult iplocate(Request request) {
        LocationResult location = null;
        try {
            location = daData.iplocate(request);
        } catch (Exception e) {

        }
        return location;
    }
}