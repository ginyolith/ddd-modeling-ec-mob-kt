package model.product

data class ProductCode(val value: String) {
    init {
        require(value.length == 5) { "商品コードは5桁である" }
    }
}