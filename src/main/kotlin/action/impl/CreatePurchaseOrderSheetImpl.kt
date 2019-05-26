package action.impl

import action.CreatePurchaseOrderSheet
import anticorrunption.PurchaseOrderAdapter
import order.model.order.PurchaseOrder
import shopping.model.cart.Cart
import shopping.repository.CartRepository

class CreatePurchaseOrderSheetImpl(
        private val cartRepository: CartRepository,
        private val adapter: PurchaseOrderAdapter
) : CreatePurchaseOrderSheet {
    override fun execute(input: Unit): PurchaseOrder {
        val cart = cartRepository.cart

        // カートの中身を初期化
        cartRepository.cart = Cart(emptyList())

        return adapter.execute(cart)

    }
}