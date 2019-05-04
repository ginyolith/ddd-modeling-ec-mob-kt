package order.model.order

/**
 * 発注書項目
 * 「客が○○を購入する」で意味が通るか否かで判断する by おーひらさん
 */
data class OrderItem(
        val name: OrderItemName,
        val unitPrice: UnitPrice,
        val quantity: Quantity) {

    fun totalPrice(): Int {
        TODO()
    }

}