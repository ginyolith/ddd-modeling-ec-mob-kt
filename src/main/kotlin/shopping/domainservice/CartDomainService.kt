package shopping.domainservice

import shopping.model.cart.Cart
import shopping.model.cart.CartItem
import shopping.model.cart.Quantity
import shopping.model.product.Product

class CartDomainService {
    fun addCartItem(cart : Cart, product: Product, quantity: Quantity) : Cart {
        val cartItem = CartItem(product,quantity)

        return Cart(items = mutableListOf(cartItem).also { it.addAll(cart.items) })
    }
}