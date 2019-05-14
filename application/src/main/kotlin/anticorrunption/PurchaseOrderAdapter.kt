package anticorrunption

import order.model.OrderItem
import order.model.PurchaseOrder
import order.vo.OrderItemName
import order.vo.PurchaseOrderId
import order.vo.Quantity
import order.vo.UnitPrice
import repository.PurchaseOrderRepository
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