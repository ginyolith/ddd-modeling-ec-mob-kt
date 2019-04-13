package repository

import model.product.Product

interface ProductRepository {
    fun find(productCode:String): Product?
}