package repository

import shopping.product.model.Product
import shopping.product.vo.ProductCode
import shopping.product.vo.ProductName
import shopping.product.vo.UnitPrice

internal class ProductRepositoryImpl : ProductRepository {

    private val database : List<Product> = listOf(
            Triple("いちご","150","001"),
            Triple("米","200","002"),
            Triple("みかん","250","003"),
            Triple("なす","300","004"),
            Triple("とちおとめ","400","005"))
            .map {
                Product(
                        productName = ProductName(it.first),
                        unitPrice = UnitPrice(it.second.toInt()),
                        productCode = ProductCode(it.third))
            }

    override fun find(productCode: String): Product? {
        return database.firstOrNull { it.productCode.value == productCode }
    }
}