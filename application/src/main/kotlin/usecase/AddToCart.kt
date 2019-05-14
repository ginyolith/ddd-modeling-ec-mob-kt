package usecase

import repository.CartRepository
import repository.ProductRepository
import shopping.cart.model.Cart
import shopping.cart.vo.Quantity
import shopping.domainservice.CartDomainService

interface AddToCart : UseCase<List<String>, Boolean>

internal class AddToCartImpl(private val repo: ProductRepository, private val cartRepository: CartRepository) : AddToCart {

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