package shopping.domainservice

import shopping.cart.model.Cart
import shopping.cart.model.CartItem
import shopping.cart.vo.Quantity
import shopping.product.model.Product

class CartDomainService {
    fun addCartItem(cart : Cart, product: Product, quantity: Quantity) : Cart {
        val cartItem = CartItem(product, quantity)

        return Cart(items = mutableListOf(cartItem).also { it.addAll(cart.items) })
    }
}