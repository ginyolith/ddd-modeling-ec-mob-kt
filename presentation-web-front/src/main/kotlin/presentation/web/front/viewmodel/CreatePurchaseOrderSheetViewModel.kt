package presentation.web.front.viewmodel

import order.model.order.PurchaseOrder

internal class CreatePurchaseOrderSheetViewModel(order : PurchaseOrder) {
    val items : List<String>
        = order.items.map { "${it.name.value}, ${it.quantity.value}個, 単価${it.unitPrice.value}円, 合計：${it.totalPrice}円" }

    val orderItemAmount = "${order.orderItemAmout}円"
}