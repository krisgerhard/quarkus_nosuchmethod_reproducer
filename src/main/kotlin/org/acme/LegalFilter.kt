package org.acme

import jakarta.annotation.Priority
import jakarta.ws.rs.Priorities.AUTHENTICATION
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ContainerRequestFilter
import jakarta.ws.rs.container.ResourceInfo
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.Status.UNAVAILABLE_FOR_LEGAL_REASONS
import jakarta.ws.rs.ext.Provider

@Provider
@Priority(AUTHENTICATION)
@InterceptingAnnotation
class LegalFilter : ContainerRequestFilter {

    @Context
    lateinit var resourceInfo: ResourceInfo

    override fun filter(context: ContainerRequestContext) {
        if (hasAnnotation()) return

        context.abortWith(Response.status(UNAVAILABLE_FOR_LEGAL_REASONS).build())
    }

    private fun hasAnnotation(): Boolean =
        resourceInfo.resourceClass.getAnnotation(InterceptingAnnotation::class.java) != null ||
                resourceInfo.resourceMethod.getAnnotation(InterceptingAnnotation::class.java) != null
}
