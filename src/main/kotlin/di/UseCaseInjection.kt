package di

import action.AddToCart
import action.Authenticate
import action.CreatePurchaseOrderSheet
import action.ShowCartItems
import action.impl.AddToCartImpl
import action.impl.AuthenticateImpl
import action.impl.CreatePurchaseOrderSheetImpl
import action.impl.ShowCartItemsImpl
import anticorrunption.PurchaseOrderAdapter

object UseCaseInjection {

    val addToCart: AddToCart by lazy {
        AddToCartImpl(cartRepository = DataInjection.cartRepository, repo = DataInjection.productRepository)
    }

    val showCartItems: ShowCartItems by lazy {
        ShowCartItemsImpl(DataInjection.cartRepository)
    }

    val createPurchaseOrderSheet: CreatePurchaseOrderSheet by lazy {
        val adapter = PurchaseOrderAdapter(DataInjection.purchaseOrderRepository)
        CreatePurchaseOrderSheetImpl(DataInjection.cartRepository, adapter)
    }

    val authentication : Authenticate by lazy {
        AuthenticateImpl(repo = DataInjection.authenticationRepository)
    }
}
