package com.example.view

import com.example.viewmodel.CreatePurchaseOrderSheetViewModel
import io.ktor.application.ApplicationCall
import io.ktor.html.respondHtml
import kotlinx.html.*

internal class CreatePurchaseOrderSheetView(private val viewModel : CreatePurchaseOrderSheetViewModel) : View {
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