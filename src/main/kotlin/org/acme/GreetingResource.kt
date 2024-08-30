package org.acme

import io.quarkus.security.Authenticated
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.MediaType.TEXT_PLAIN
import jakarta.ws.rs.core.SecurityContext

@Path("/hello")
class GreetingResource {

    @GET
    @Path("/one")
    @Produces(TEXT_PLAIN)
    @InterceptingAnnotation
    fun hello() = "Hello from Quarkus REST"


    @GET
    @Path("/two")
    @Produces(TEXT_PLAIN)
    @InterceptingAnnotation
    @Authenticated
    fun helloAuthenticated(@Context securityContext: SecurityContext) = "Hello from Quarkus REST (authenticated)"
}
