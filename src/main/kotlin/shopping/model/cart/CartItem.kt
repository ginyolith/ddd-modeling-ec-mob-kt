package shopping.model.cart

import shopping.model.product.Product

data class CartItem(
        val product: Product,
        val quantity: Quantity) {

    val 小計 = shopping.model.cart.小計(product.unitPrice.value * quantity.value)
}