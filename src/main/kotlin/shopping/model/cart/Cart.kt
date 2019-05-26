package shopping.model.cart

data class Cart(
        val items : List<CartItem>
) {
    val 小計 = items.map { it.小計.value }.sum().let { 小計(it) }
}