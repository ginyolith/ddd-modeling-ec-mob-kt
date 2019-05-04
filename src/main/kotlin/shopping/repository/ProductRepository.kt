package shopping.repository

import shopping.model.product.Product

interface ProductRepository {
    fun find(productCode:String): Product?
}