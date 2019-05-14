package presentation.web.front

import di.Injection
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import presentation.web.front.view.AddToCartView
import presentation.web.front.view.CreatePurchaseOrderSheetView
import presentation.web.front.view.ShowCartItemsView
import presentation.web.front.viewmodel.AddToCartViewModel
import presentation.web.front.viewmodel.CreatePurchaseOrderSheetViewModel
import presentation.web.front.viewmodel.ShowCartItemsViewModel

fun main(args: Array<String>) {
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


@JvmOverloads
fun Application.mymodule(@Suppress("UNUSED_PARAMETER") testing: Boolean = false) {
    routing {
        get("/addToCart") {
            val params = call.request.queryParameters["items"]
                    .toString()
                    .split(",")

            val result = Injection.addToCart.execute(params)
            val viewModel = AddToCartViewModel(result)
            val view = AddToCartView(viewModel)

            view.render(call)
        }

        get("/showCartItems") {
            val result = Injection.showCartItems.execute(Unit)
            val viewModel = ShowCartItemsViewModel(result)
            val view = ShowCartItemsView(viewModel)

            view.render(call)
        }

        get("/createPurchaseOrderSheet") {
            val result = Injection.createPurchaseOrderSheet.execute(Unit)
            val viewModel = CreatePurchaseOrderSheetViewModel(result)
            val view = CreatePurchaseOrderSheetView(viewModel)

            view.render(call)
        }
    }
}