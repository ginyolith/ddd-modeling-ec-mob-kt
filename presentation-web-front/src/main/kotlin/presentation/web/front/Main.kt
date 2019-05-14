package presentation.web.front

import di.Injection
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.css.*
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.FlowOrMetaDataContent
import kotlinx.html.style
import presentation.web.front.view.AddToCartView
import presentation.web.front.view.CreatePurchaseOrderSheetView
import presentation.web.front.view.ShowCartItemsView
import presentation.web.front.viewmodel.AddToCartViewModel
import presentation.web.front.viewmodel.CreatePurchaseOrderSheetViewModel
import presentation.web.front.viewmodel.ShowCartItemsViewModel

fun main(args: Array<String>): Unit {
    val env = applicationEngineEnvironment {
        module {
            mymodule()
        }

        connector {
            host = "0.0.0.0"
            port = 8081
        }
    }

    embeddedServer(Netty, env).start()
}

fun Application.mymodule(testing: Boolean = false) {
    routing {
        get("/addToCart") {
            call.request.queryParameters["items"]
                    .toString()
                    .split(",")
                    .let { Injection.addToCart.execute(it) }
                    .let { AddToCartViewModel(it) }
                    .let { AddToCartView(it) }
                    .let { call.respondHtml(block = it.html()) }
        }

        get("/showCartItems") {
            Injection.showCartItems.execute(Unit)
                    .let { ShowCartItemsViewModel(it) }
                    .let { ShowCartItemsView(it) }
                    .let { call.respondHtml(block = it.html()) }
        }

        get("/createPurchaseOrderSheet") {
            Injection.createPurchaseOrderSheet.execute(Unit)
                    .let { CreatePurchaseOrderSheetViewModel(it) }
                    .let { CreatePurchaseOrderSheetView(it) }
                    .let { call.respondHtml(block = it.html()) }
        }

        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.red
                }
                p {
                    fontSize = 2.em
                }
                rule("p.myclass") {
                    color = Color.blue
                }
            }
        }
    }
}

fun FlowOrMetaDataContent.styleCss(builder: CSSBuilder.() -> Unit) {
    style(type = ContentType.Text.CSS.toString()) {
        +CSSBuilder().apply(builder).toString()
    }
}

fun CommonAttributeGroupFacade.style(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString().trim()
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
