package action.impl

import action.AddToCart
import domainservice.CartDomainService
import model.cart.Cart
import model.cart.Quantity
import repository.ProductRepository

class AddToCartImpl(private val repo : ProductRepository) : AddToCart {

    var cart = Cart(emptyList())

    private val service = CartDomainService()

    override fun execute(input: List<String>): Boolean {
        val products = input.map { repo.find(it) }

        return if (products.any { it == null }) {
            false
        } else {
            products
                    .filterNotNull()
                    .forEach {product ->
                        cart = service.addCartItem(cart, product, Quantity(1))
                    }

            true
        }
    }
}