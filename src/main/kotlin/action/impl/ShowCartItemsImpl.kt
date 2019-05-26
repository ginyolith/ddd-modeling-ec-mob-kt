package action.impl

import action.ShowCartItems
import shopping.model.cart.Cart
import shopping.repository.CartRepository

class ShowCartItemsImpl(private val cartRepository: CartRepository) : ShowCartItems {
    override fun execute(input: Unit): Cart {
        return cartRepository.cart
    }
}