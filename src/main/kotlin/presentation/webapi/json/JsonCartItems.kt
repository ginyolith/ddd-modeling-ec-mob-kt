package presentation.webapi.json

// Todo:JsonCartItemsの名前は再考の余地がある
data class JsonCartItems(
        val items: List<JsonCartItem>,
        val subTotal: Int
)

data class JsonCartItem(
        val productName: String,
        val unitPrice: Int,
        val quantity: Int,
        val totalPrice: Int
)
