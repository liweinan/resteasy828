package org.simple;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Component
@Path("/")
@Produces("application/json")
public class ServletContextAwareService {

    @GET
    @Path("/inject")
    @Produces("application/json")
    public String status(@Context ServletContext context) {

        return context.getInitParameter("should.be.available");

    }
}
