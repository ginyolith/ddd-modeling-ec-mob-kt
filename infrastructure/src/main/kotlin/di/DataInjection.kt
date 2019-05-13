package di

import repository.*
import repository.CartRepositoryImpl
import repository.ProductRepositoryImpl

object DataInjection {
    val cartRepository : CartRepository = CartRepositoryImpl()

    val productRepository : ProductRepository = ProductRepositoryImpl()

    val purchaseOrderRepository: PurchaseOrderRepository = PurchaseOrderRepositoryImpl()
}