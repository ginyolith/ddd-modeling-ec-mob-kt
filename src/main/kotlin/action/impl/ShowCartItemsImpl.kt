package action.impl

import action.ShowCartItems
import repository.CartRepository

class ShowCartItemsImpl(private val cartRepository: CartRepository) : ShowCartItems {
    override fun execute(input: Unit): String {
        return cartRepository.cart.showCartItems()
    }
}