package presentation.web.front.view

import presentation.web.front.viewmodel.AddToCartViewModel
import io.ktor.application.ApplicationCall
import io.ktor.html.respondHtml
import kotlinx.html.*

internal class AddToCartView(private val viewModel : AddToCartViewModel) : View {
    override fun html(): HTML.() -> Unit = {
        body {
            h1 {
                if (viewModel.result) {
                    +"カートへの商品の追加に成功しました"
                } else {
                    a {
                        style = "color : red"
                        +"カートへの商品の追加に失敗しました"
                    }
                }
            }
        }
    }
}