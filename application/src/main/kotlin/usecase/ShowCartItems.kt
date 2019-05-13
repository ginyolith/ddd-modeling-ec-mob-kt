package usecase

import repository.CartRepository
import shopping.cart.model.Cart

interface ShowCartItems : UseCase<Unit, Cart>

internal class ShowCartItemsImpl(private val cartRepository: CartRepository) : ShowCartItems {
    override fun execute(input: Unit): Cart {
        return cartRepository.cart
    }
}