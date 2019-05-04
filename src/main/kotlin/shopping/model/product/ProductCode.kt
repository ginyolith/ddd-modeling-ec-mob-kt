package shopping.model.product

data class ProductCode(val value: String) {
    init {
        require(value.length == 3) { "商品コードは3桁である" }
    }
}