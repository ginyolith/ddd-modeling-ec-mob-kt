package order

import order.vo.PurchaseOrderId
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class PurchaseOrderIdTest {
    @Test
    fun testPurchaseOrderIdFormat() {
        assertThatCode {
            PurchaseOrderId("001")
        }
                .doesNotThrowAnyException()
    }

    @Test
    fun testPurchaseOrderIdIllegalFormat1() {
        assertThatThrownBy {
            PurchaseOrderId("0014")
        }
                .isInstanceOf(IllegalArgumentException::class.java)

    }

    @Test
    fun testPurchaseOrderIdIllegalFormat2() {
        assertThatThrownBy {
            PurchaseOrderId("000")
        }
                .isInstanceOf(IllegalArgumentException::class.java)
    }
}