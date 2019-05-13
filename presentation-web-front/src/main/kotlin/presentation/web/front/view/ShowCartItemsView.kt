package presentation.web.front.view

import presentation.web.front.viewmodel.ShowCartItemsViewModel
import io.ktor.application.ApplicationCall
import io.ktor.html.respondHtml
import kotlinx.html.*

internal class ShowCartItemsView(private val viewModel: ShowCartItemsViewModel) : View {
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