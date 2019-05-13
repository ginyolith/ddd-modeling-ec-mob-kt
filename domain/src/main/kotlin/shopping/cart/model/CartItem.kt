package shopping.cart.model

import shopping.cart.vo.Quantity
import shopping.product.model.Product

data class CartItem(
        val product: Product,
        val quantity: Quantity) {

    val 小計 = shopping.cart.vo.小計(product.unitPrice.value * quantity.value)
}