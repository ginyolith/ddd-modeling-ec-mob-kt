package presentation.web.front.view

import kotlinx.html.*
import presentation.web.front.viewmodel.ShowCartItemsViewModel

internal class ShowCartItemsView(private val viewModel: ShowCartItemsViewModel) : HtmlView() {
    override fun html(): HTML.() -> Unit = {
        body {
            h1 { +"カートの中身一覧ページ" }
            ul {
                viewModel.items.forEach {item ->
                    li { +item }
                }
            }
            h2 {
                +viewModel.sum
            }
        }
    }
}