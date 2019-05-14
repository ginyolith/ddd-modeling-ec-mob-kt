package di

import usecase.*

object Injection {
    val addToCart : AddToCart by lazy {
        AppInjection.provideAddToCart(cart =DataInjection.cartRepository, product = DataInjection.productRepository)
    }

    val showCartItems : ShowCartItems by lazy {
        AppInjection.provideShowCartItems(DataInjection.cartRepository)
    }

    val createPurchaseOrderSheet : CreatePurchaseOrderSheet by lazy {
        AppInjection.provideCreatePurchaseOrderSheet(DataInjection.cartRepository, DataInjection.purchaseOrderRepository)
    }
}