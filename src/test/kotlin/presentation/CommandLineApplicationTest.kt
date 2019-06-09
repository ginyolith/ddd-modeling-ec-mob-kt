package presentation

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class CommandLineApplicationTest {

    private val app = CommandLineApplication

    @Before
    fun setUp() {

    }

//    @Test
//    fun addToCart() {
////        いちご,150,001
////        米,200,002
////        みかん,250,003
////        なす,300,004
////        とちおとめ,400,005
//
////        ### 入力テキスト
////        001,001,002
////        ..
//
//        // 正常系
//        app.addToCart("001", "001", "003").let {
//            assertThat(it)
//                    .`as`("正常系。有効な商品コードのみ入力されていた場合True")
//                    .isTrue()
//        }
//
//        // 異常系
//        app.addToCart("999").let {
//            assertThat(it)
//                    .`as`("異常系。無効な商品コードのみ入力されていた場合False")
//                    .isFalse()
//        }
//    }
//
//    @Test
//    fun showCartItems() {
////        ### 出力テキスト（購入する）
////        商品名,単価,数量,合計
////        いちご,150,3,450
////        みかん,200,1,200
////        なす,300,1,300
////        小計: 900円
//
//        //        いちご,150,001
////        米,200,002
////        みかん,250,003
////        なす,300,004
////        とちおとめ,400,005
//
//        // 商品をカートに入れる
//        app.addToCart(
//                "001", "001", "001",//いちご3個
//                "003", //みかん1個
//                "004" // なす１個
//        )
//
//        //　カート項目の一覧を返す
//        assertThat(app.showCartItems())
//                .isEqualTo("""商品名,単価,数量,合計
//いちご,150,3,450
//みかん,250,1,250
//なす,300,1,300
//小計: 1000円""".trimIndent())
//    }
//
//    @Test
//    fun createPurchaseOrderSheet() {
////        ### 出力テキスト（閲覧する）
////        商品名,単価,数量,合計
////        いちご,150,3,450
////        みかん,200,1,200
////        れもん,250,1,250
////        小計: 900円
//
//        // 商品をカートに入れる
//        app.addToCart(listOf(
//                "001", "001", "001",//いちご3個
//                "003", //みかん1個
//                "004" // なす１個
//        )
//        )
//
//        //　カート項目の一覧を返す
//        // TODO なぜここでカート項目の一覧を呼んでいる？
//        assertThat(app.showCartItems())
//                .isEqualTo("""商品名,単価,数量,合計
//いちご,150,3,450
//みかん,250,1,250
//なす,300,1,300
//小計: 1000円""".trimIndent())
//
//        // 発注書を返す
//        assertThat(app.createPurchaseOrderSheet())
//                .isEqualTo("""発注書ID:001
//品目,単価,数量,合計
//いちご,150,3,450
//みかん,250,1,250
//なす,300,1,300
//小計: 1000円""".trimIndent())
//
//        // カートの中身が空になってる
//        assertThat(app.showCartItems())
//                .isEqualTo("""商品名,単価,数量,合計
//小計: 0円""")
//    }

    @Test
    fun testAddToCartAuthorization() {
        // ユーザーID1
        "1".let { auth ->
            // いちごを追加
            app.addToCart(auth = auth, productCodeList = listOf("001"))
        }

        // ユーザ２
        "2".let { auth ->
            // なすを追加
            app.addToCart(auth = auth, productCodeList = listOf("004"))

            assertThat(app.showCartItems(auth = auth))
                    .`as`(" ユーザー２は、なすのみがカートの中身である")
                    .isEqualTo("""商品名,単価,数量,合計
なす,300,1,300
小計: 300円""".trimIndent())
        }

        assertThat(app.showCartItems(auth = "1"))
                .`as`(" ユーザー１は、いちごのみがカートの中身である")
                .isEqualTo("""商品名,単価,数量,合計
いちご,150,1,150
小計: 150円""".trimIndent())
    }
}