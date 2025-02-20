package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/hello/one")
          .then()
             .statusCode(200)
             .body(`is`("Hello from Quarkus REST"))
    }

    @Test
    fun testHelloAuthenticatedEndpoint() {
        given()
            .`when`().get("/hello/two")
            .then()
            .statusCode(200)
            .body(`is`("Hello from Quarkus REST (authenticated)"))
    }


}
