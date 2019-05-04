package order.model.order

data class PurchaseOrder(
        val id: PurchaseOrderId,
        val items: List<OrderItem>
) {
    // FIXME IntはMoney型などVO化する必要がある？
    val orderItemAmout: Int = TODO()

    val paymentAmout: Int = TODO()
}