package di

import anticorrunption.PurchaseOrderAdapter
import repository.CartRepository
import repository.ProductRepository
import repository.PurchaseOrderRepository
import usecase.*

object AppInjection {

    fun provideAddToCart(cart : CartRepository, product : ProductRepository): AddToCart {
        return AddToCartImpl(cartRepository = cart, repo = product)
    }

    fun provideShowCartItems(cart : CartRepository): ShowCartItems {
        return ShowCartItemsImpl(cart)
    }

    fun provideCreatePurchaseOrderSheet(cart : CartRepository, purchaseOrder : PurchaseOrderRepository)
            : CreatePurchaseOrderSheet {
        return CreatePurchaseOrderSheetImpl(cart, PurchaseOrderAdapter(purchaseOrder))
    }
}