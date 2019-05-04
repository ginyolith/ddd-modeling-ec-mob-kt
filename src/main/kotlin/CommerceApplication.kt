import action.CreatePurchaseOrderSheet
import action.ShowCartItems
import action.impl.AddToCartImpl
import action.impl.CreatePurchaseOrderSheetImpl
import action.impl.ShowCartItemsImpl
import anticorrunption.PurchaseOrderAdapter
import order.repository.PurchaseOrderRepository
import order.repository.PurchaseOrderRepositoryImpl
import shopping.repository.CartRepository
import shopping.repository.CartRepositoryImpl
import shopping.repository.ProductRepositoryImpl

object CommerceApplication {

    private val cartRepository: CartRepository = CartRepositoryImpl()

    private val purchaseOrderRepository: PurchaseOrderRepository = PurchaseOrderRepositoryImpl()

    private val adapter: PurchaseOrderAdapter = PurchaseOrderAdapter(purchaseOrderRepository)

    private val addToCart = AddToCartImpl(ProductRepositoryImpl(), cartRepository)

    private val showCartItems: ShowCartItems = ShowCartItemsImpl(cartRepository)

    private val createPurchaseOrderSheet: CreatePurchaseOrderSheet = CreatePurchaseOrderSheetImpl(cartRepository, adapter)

    /**
     * カートに商品を追加する
     * @param productCode 商品コード
     */
    fun addToCart(vararg productCode : String) : Boolean{
        return addToCart.execute(productCode.toList())
    }

    /**
     * カート項目の一覧を表示する
     */
    fun showCartItems() : String {
        return showCartItems.execute(Unit)
    }

    /**
     * 発注書を生成する
     */
    fun createPurchaseOrderSheet() : String {
        return createPurchaseOrderSheet.execute(Unit)
    }
}