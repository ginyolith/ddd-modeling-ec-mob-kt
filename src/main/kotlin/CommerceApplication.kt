import action.impl.AddToCartImpl
import repository.ProductRepositoryImpl

object CommerceApplication {

    private val addToCart = AddToCartImpl(ProductRepositoryImpl())

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
        TODO("not implemented")
    }

    /**
     * 発注書を生成する
     */
    fun createPurchaseOrderSheet() : String {
        TODO("not implemented")
    }
}