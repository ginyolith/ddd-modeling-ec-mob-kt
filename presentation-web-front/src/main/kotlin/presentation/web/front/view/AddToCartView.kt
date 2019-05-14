package presentation.web.front.view

import kotlinx.html.*
import presentation.web.front.viewmodel.AddToCartViewModel

internal class AddToCartView(private val viewModel: AddToCartViewModel) : HtmlView() {
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