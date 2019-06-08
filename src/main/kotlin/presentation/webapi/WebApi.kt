package presentation.webapi

import com.squareup.moshi.Moshi
import di.UseCaseInjection
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.header
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import presentation.webapi.json.JsonCartItem
import presentation.webapi.json.JsonCartItems


fun Application.main() {
    // カートへの追加処理
    val addToCart = UseCaseInjection.addToCart

    // カートの中身を見る処理
    val showCartItems = UseCaseInjection.showCartItems

    // 発注書を生成する処理
    val createPurchaseOrderSheet = UseCaseInjection.createPurchaseOrderSheet

    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
        get("/v1/cart/show") {

            val cart: JsonCartItems = showCartItems.execute(Unit).let {
                val jsonCartItemList = it.items.map {
                    JsonCartItem(
                            productName = it.product.productName.value,
                            unitPrice = it.product.unitPrice.value,
                            quantity = it.quantity.value,
                            totalPrice = it.小計.value
                    )
                }

                JsonCartItems(jsonCartItemList, it.小計.value)
            }

            val moshi = Moshi.Builder().build()
            val json = moshi.adapter(JsonCartItems::class.java).toJson(cart)

            call.respondText(json, ContentType.Application.Json, status = HttpStatusCode.OK)
        }
        post("/v1/cart/add") {
            val param = requireNotNull(call.request.header("productCodes"))
            val productCodes = param.split(",")

            addToCart.execute(productCodes)

            call.respondText("Success", ContentType.Text.Plain, status = HttpStatusCode.OK)
        }
    }
}