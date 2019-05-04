package order.model.order

data class OrderItem(
        val name: OrderItemName,
        val unitPrice: UnitPrice,
        val quantity: Quantity) {

    fun totalPrice(): Int {
        TODO()
    }

}