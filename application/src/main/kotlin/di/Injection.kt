package di

import anticorrunption.PurchaseOrderAdapter
import usecase.*

object Injection {
    private val adapter: PurchaseOrderAdapter = PurchaseOrderAdapter(DataInjection.purchaseOrderRepository)

    val addToCart : AddToCart by lazy {
        AddToCartImpl(cartRepository = DataInjection.cartRepository, repo = DataInjection.productRepository)
    }

    val showCartItems : ShowCartItems by lazy {
        ShowCartItemsImpl(DataInjection.purchaseOrderRepository)
    }

    val createPurchaseOrderSheet : CreatePurchaseOrderSheet by lazy {
        CreatePurchaseOrderSheetImpl(DataInjection.cartRepository, adapter)
    }
}