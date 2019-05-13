package presentation.web.front.viewmodel

import shopping.cart.model.Cart


internal class ShowCartItemsViewModel(cart : Cart) {
    val items : List<String>
        = cart.items
            .map {
                "${it.product.productName.value}, ${it.quantity.value}個, 小計：${it.小計.value}"
            }

    val sum : String
        = "小計：${cart.小計.value}円"
}