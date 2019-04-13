package repository

import model.cart.Cart

class CartRepositoryImpl(override var cart: Cart = Cart(emptyList())) : CartRepository {

}