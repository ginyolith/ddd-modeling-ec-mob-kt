import action.ShowCartItems
import action.impl.AddToCartImpl
import action.impl.ShowCartItemsImpl
import shopping.repository.CartRepository
import shopping.repository.CartRepositoryImpl
import shopping.repository.ProductRepositoryImpl

object CommerceApplication {

    private val cartRepository: CartRepository = CartRepositoryImpl()

    private val addToCart = AddToCartImpl(ProductRepositoryImpl(), cartRepository)

    private val showCartItems: ShowCartItems = ShowCartItemsImpl(cartRepository)

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
        TODO("not implemented")
    }
}