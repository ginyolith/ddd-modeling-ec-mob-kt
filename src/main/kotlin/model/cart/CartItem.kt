package model.cart

import model.product.Product

data class CartItem(
        val product: Product,
        val quantity: Quantity) {

    val 小計 = model.cart.小計(product.unitPrice.value * quantity.value)
}