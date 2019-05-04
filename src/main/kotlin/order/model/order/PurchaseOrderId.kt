package order.model.order

//TODO idをIntで保持する？
data class PurchaseOrderId(val value: String) {
    init {
        require(Regex("[0-9]{2}[1-9]").matches(value)) { "IDは0埋め3桁とするとする" }
    }
}
