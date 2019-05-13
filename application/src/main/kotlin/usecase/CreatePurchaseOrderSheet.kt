package usecase

import anticorrunption.PurchaseOrderAdapter
import order.model.PurchaseOrder
import repository.CartRepository
import shopping.cart.model.Cart

interface CreatePurchaseOrderSheet : UseCase<Unit, PurchaseOrder>

internal class CreatePurchaseOrderSheetImpl(
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