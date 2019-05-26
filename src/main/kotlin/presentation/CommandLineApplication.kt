package presentation

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

object CommandLineApplication {

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
        val cart = showCartItems.execute(Unit)

        val list = mutableListOf<String>()

        list.add("商品名,単価,数量,合計")

        cart.items
                .forEach {
                    list.add("${it.product.productName.value},${it.product.unitPrice.value},${it.quantity.value},${it.小計.value}")
                }


        list.add("小計: ${cart.小計.value}円")

        return list.joinToString("\n")
    }

    /**
     * 発注書を生成する
     */
    fun createPurchaseOrderSheet() : String {
        val order = createPurchaseOrderSheet.execute(Unit)


        // 発注書の中身を文字列として返す

        //発注書ID:001
        //品目,単価,数量,合計
        //いちご,150,3,450
        //みかん,200,1,200
        //なす,300,1,250
        //小計: 900円

        val sb: MutableList<String> = mutableListOf()

        sb.add("発注書ID:${order.id.value}")
        sb.add("品目,単価,数量,合計")
        order.items.forEach {
            sb.add("${it.name.value},${it.unitPrice.value},${it.quantity.value},${it.totalPrice}")
        }
        sb.add("小計: ${order.paymentAmout}円")

        return sb.joinToString("\n")
    }
}