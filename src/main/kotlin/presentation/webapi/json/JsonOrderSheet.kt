package presentation.webapi.json


data class JsonOrderSheet(
        val orderId : String,
        val items: List<JsonOrderItem>,
        val subTotal: Int
)

data class JsonOrderItem(
        val productName: String,
        val unitPrice: Int,
        val quantity: Int,
        val totalPrice: Int
)
