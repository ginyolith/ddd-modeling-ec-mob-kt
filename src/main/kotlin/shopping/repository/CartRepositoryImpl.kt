package shopping.repository

import shopping.model.cart.Cart

class CartRepositoryImpl(override var cart: Cart = Cart(emptyList())) : CartRepository {

}