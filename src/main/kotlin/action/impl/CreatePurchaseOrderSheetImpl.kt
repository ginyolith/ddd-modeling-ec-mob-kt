package action.impl

import action.CreatePurchaseOrderSheet
import anticorrunption.PurchaseOrderAdapter
import shopping.model.cart.Cart
import shopping.repository.CartRepository

class CreatePurchaseOrderSheetImpl(
        private val cartRepository: CartRepository,
        private val adapter: PurchaseOrderAdapter
) : CreatePurchaseOrderSheet {
    override fun execute(input: Unit): String {
        val cart = cartRepository.cart

        // カートの中身を初期化
        cartRepository.cart = Cart(emptyList())

        val order = adapter.execute(cart)

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

        return sb.joinToString("\n")
    }
}