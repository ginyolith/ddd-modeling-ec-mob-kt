package presentation.webapi

import io.ktor.application.Application
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.Test
import kotlin.test.assertEquals

class WebApiTest {
    @Test
    fun testHello() = withTestApplication(Application::main) {

        handleRequest(HttpMethod.Get, "/")
        .run {
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals("Hello World!", response.content)
        }
    }

    @Test
    fun testShow() = withTestApplication(Application::main) {

        handleRequest(HttpMethod.Get, "/v1/cart/show")
        .run {
            assertEquals(HttpStatusCode.OK, response.status())
            // TODO Textではなく、JsonによるAssertion
            assertEquals("{\"items\":[],\"subTotal\":0}", response.content)
        }
    }

    @Test
    fun testCreate() = withTestApplication(Application::main) {

        handleRequest(HttpMethod.Post, "/v1/cart/add") {
            // Request set up
            addHeader(HttpHeaders.Accept, ContentType.Text.Plain.toString())
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            addHeader("productCodes", "001,002")

        }.run {
            assertEquals(HttpStatusCode.OK, response.status())
            // TODO Add結果のAssertion
        }
    }
}