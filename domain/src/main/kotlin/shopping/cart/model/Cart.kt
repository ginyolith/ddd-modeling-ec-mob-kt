package shopping.cart.model

data class Cart(
        val items : List<CartItem>
) {
    val 小計 = items.map { it.小計.value }.sum().let { shopping.cart.vo.小計(it) }
}