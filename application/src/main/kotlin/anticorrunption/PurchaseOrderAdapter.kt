package anticorrunption

import order.model.order.*
import order.repository.PurchaseOrderRepository
import shopping.cart.model.Cart

internal class PurchaseOrderAdapter(private val repository: PurchaseOrderRepository) {

    fun execute(cart: Cart): PurchaseOrder {
        val orderItems: List<OrderItem> = cart
                .items
                .map {
                    OrderItem(
                            name = OrderItemName(it.product.productName.value),
                            unitPrice = UnitPrice(it.product.unitPrice.value),
                            quantity = Quantity(it.quantity.value))
                }

        val purchaseOrderId: PurchaseOrderId = PurchaseOrderId(String.format("%03d", repository.getNextId()))

        return PurchaseOrder(
                id = purchaseOrderId,
                items = orderItems)
    }
}