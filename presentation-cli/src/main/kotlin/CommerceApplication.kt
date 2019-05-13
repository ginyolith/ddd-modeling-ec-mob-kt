import di.Injection
import view.CreatePurchaseOrderSheetView
import view.ShowCartItemsView

internal object CommerceApplication {
    private val addToCart = Injection.addToCart

    private val showCartItems = Injection.showCartItems

    private val createPurchaseOrderSheet = Injection.createPurchaseOrderSheet

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
                .let { ShowCartItemsView(it).string }
    }

    /**
     * 発注書を生成する
     */
    fun createPurchaseOrderSheet() : String {
        return createPurchaseOrderSheet.execute(Unit)
                .let { CreatePurchaseOrderSheetView(it).string }
    }
}