package shopping.product

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
class UnitPriceTest {

    @Test
    fun test単価は0以上の整数であること() {
        // 正常系
        assertThatCode {
            UnitPrice(1)
        }
                .doesNotThrowAnyException()

        // 異常系
        assertThatThrownBy {
            UnitPrice(-1)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
    }
}