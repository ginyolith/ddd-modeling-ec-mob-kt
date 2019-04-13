package model.cart

data class Quantity(val value: Int) {
    init {
        require(value >= 1) { "1以上の整数である" }
        require(value <= 99) { "99以下の整数である" }
    }
}