package order.model.order

data class PurchaseOrder(
        val id: PurchaseOrderId,
        val items: List<OrderItem>
) {
    // FIXME IntはMoney型などVO化する必要がある？
    val orderItemAmout: Int = items.map { it.totalPrice }.sum()

    val paymentAmout: Int = items.map { it.totalPrice }.sum()
}