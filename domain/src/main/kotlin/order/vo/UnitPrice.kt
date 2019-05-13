package order.vo

// TODO BigDecimalでプリミティブな値を保持する？
data class UnitPrice(val value: Int) {
    init {
        require(value >= 0) { "単価は0以上の整数であること" }
    }
}