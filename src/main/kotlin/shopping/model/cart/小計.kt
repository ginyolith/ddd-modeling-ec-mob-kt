package shopping.model.cart

class 小計(val value: Int) {

    init {
        require(0 <= value) { "0以上の整数である" }
    }
}