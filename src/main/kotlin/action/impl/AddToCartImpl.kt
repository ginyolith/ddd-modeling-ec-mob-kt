package action.impl

import action.AddToCart
import shopping.domainservice.CartDomainService
import shopping.model.cart.Cart
import shopping.model.cart.Quantity
import shopping.repository.CartRepository
import shopping.repository.ProductRepository

class AddToCartImpl(private val repo: ProductRepository, private val cartRepository: CartRepository) : AddToCart {

    private val service = CartDomainService()

    override fun execute(input: List<String>): Boolean {
        val products = input
                .map { repo.find(it) }

        return if (products.any { it == null }) {
            false
        } else {
            products
                    .filterNotNull()
                    .groupBy { it }
                    .forEach { entry ->
                        cartRepository.cart = service.addCartItem(cartRepository.cart, entry.key, Quantity(entry.value.size))
                    }

            cartRepository.cart = Cart(cartRepository.cart.items.asReversed())

            true
        }
    }
}