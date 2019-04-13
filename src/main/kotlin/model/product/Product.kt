package model.product

data class Product(
        val productCode: ProductCode,
        val productName: ProductName,
        val unitPrice: UnitPrice) {

    override fun equals(other: Any?): Boolean {
        return if (other is Product) {
            other.productCode == this.productCode
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return productCode.hashCode()
    }
}