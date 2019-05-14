package presentation.web.front.view

import kotlinx.html.*
import presentation.web.front.viewmodel.CreatePurchaseOrderSheetViewModel

internal class CreatePurchaseOrderSheetView(private val viewModel: CreatePurchaseOrderSheetViewModel) : HtmlView() {
    override fun html(): HTML.() -> Unit  = {
        body {
            h1 { +"発注書" }
            h2 { +"発注項目" }
            ul {
                viewModel.items.forEach {
                    li { +it }
                }
            }
            h3 { +"合計金額${viewModel.orderItemAmount}" }
        }
    }
}