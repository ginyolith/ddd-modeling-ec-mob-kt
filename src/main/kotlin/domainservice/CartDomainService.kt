package domainservice

import model.cart.Cart
import model.cart.CartItem
import model.cart.Quantity
import model.product.Product

class CartDomainService {
    fun addCartItem(cart : Cart, product: Product, quantity: Quantity) : Cart {
        val cartItem = CartItem(product,quantity)

        return Cart(items = mutableListOf(cartItem).also { it.addAll(cart.items) })
    }
}