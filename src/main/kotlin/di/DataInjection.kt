package di

import order.repository.PurchaseOrderRepository
import order.repository.PurchaseOrderRepositoryImpl
import shopping.repository.CartRepository
import shopping.repository.CartRepositoryImpl
import shopping.repository.ProductRepository
import shopping.repository.ProductRepositoryImpl

object DataInjection {
    val cartRepository: CartRepository = CartRepositoryImpl()

    val productRepository: ProductRepository = ProductRepositoryImpl()

    val purchaseOrderRepository: PurchaseOrderRepository = PurchaseOrderRepositoryImpl()
}