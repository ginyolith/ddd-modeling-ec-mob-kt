package presentation

import di.UseCaseInjection
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


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
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }
        }
    }
    server.start(wait = true)
}