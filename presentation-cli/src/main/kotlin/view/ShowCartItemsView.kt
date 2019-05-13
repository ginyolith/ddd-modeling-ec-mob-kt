package view

import shopping.cart.model.Cart

internal class ShowCartItemsView(cart : Cart) {
    val string : String = cart.run {
        val list = mutableListOf<String>()

        list.add("商品名,単価,数量,合計")

        items
                .forEach {
                    list.add("${it.product.productName.value},${it.product.unitPrice.value},${it.quantity.value},${it.小計.value}")
                }


        list.add("小計: ${小計.value}円")

        list.joinToString("\n")
    }

}