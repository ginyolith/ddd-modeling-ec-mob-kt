package repository

import shopping.cart.model.Cart

internal class CartRepositoryImpl(override var cart: Cart = Cart(emptyList())) : CartRepository {

}