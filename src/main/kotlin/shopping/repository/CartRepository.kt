package shopping.repository

import shopping.model.cart.Cart

interface CartRepository {
    var cart: Cart
}