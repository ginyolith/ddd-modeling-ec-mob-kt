package repository

import shopping.product.model.Product

interface ProductRepository {
    fun find(productCode:String): Product?
}