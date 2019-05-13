package view

import order.model.PurchaseOrder

internal class CreatePurchaseOrderSheetView(order : PurchaseOrder) {
    val string = order.run {
        // 発注書の中身を文字列として返す

        //発注書ID:001
        //品目,単価,数量,合計
        //いちご,150,3,450
        //みかん,200,1,200
        //なす,300,1,250
        //小計: 900円

        val sb: MutableList<String> = mutableListOf()

        sb.add("発注書ID:${order.id.value}")
        sb.add("品目,単価,数量,合計")
        order.items.forEach {
            sb.add("${it.name.value},${it.unitPrice.value},${it.quantity.value},${it.totalPrice}")
        }
        sb.add("小計: ${order.paymentAmout}円")

        sb.joinToString("\n")
    }
}