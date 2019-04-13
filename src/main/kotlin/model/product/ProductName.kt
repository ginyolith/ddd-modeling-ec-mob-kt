package model.product

data class ProductName(val value: String) {
    init {
        require(value.isNotEmpty()) { "商品名は1文字以上である" }
        require(value.length <= 100) { "商品名は100文字以下である" }
    }
}