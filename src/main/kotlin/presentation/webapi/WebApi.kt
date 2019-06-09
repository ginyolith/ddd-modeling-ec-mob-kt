package presentation.webapi

import com.squareup.moshi.Moshi
import di.UseCaseInjection
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.header
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import presentation.webapi.json.JsonCartItem
import presentation.webapi.json.JsonCartItems
import presentation.webapi.json.JsonOrderItem
import presentation.webapi.json.JsonOrderSheet


fun main(args: Array<String>) {
    // カートへの追加処理
    val addToCart = UseCaseInjection.addToCart

    // カートの中身を見る処理
    val showCartItems = UseCaseInjection.showCartItems

    // 発注書を生成する処理
    val createPurchaseOrderSheet = UseCaseInjection.createPurchaseOrderSheet


    val server = embeddedServer(Netty, port = 8080) {
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
            put("/v1/order/create") {
                val order = createPurchaseOrderSheet.execute(Unit)
                // 発注書ドメインモデル -> 発注書Jsonオブジェクトへの変換
                val orderJson: JsonOrderSheet = JsonOrderSheet(
                        orderId = order.id.value,
                        items = order.items.map {
                            JsonOrderItem(
                                    productName = it.name.value,
                                    unitPrice = it.unitPrice.value,
                                    quantity = it.quantity.value,
                                    totalPrice = it.totalPrice
                            )
                        },
                        subTotal = order.paymentAmout
                )

                val moshi = Moshi.Builder().build()
                val json = moshi.adapter(JsonOrderSheet::class.java).toJson(orderJson)

                call.respondText(json, ContentType.Application.Json, status = HttpStatusCode.OK)
            }

        }
    }
    server.start(wait = true)
}