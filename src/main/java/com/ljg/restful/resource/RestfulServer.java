package com.ljg.restful.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/*
* 访问途径http://localhost:8080/restful/test
* */
@Path("/test")
public class RestfulServer extends AbstractResource {

    @GET
    //@Produces({MediaType.TEXT_PLAIN, "text/csv", MediaType.APPLICATION_JSON})
    public String sayHello(){
        String modelName = getModelManager().getModelName();
        return "hello," + modelName;
    }
}
