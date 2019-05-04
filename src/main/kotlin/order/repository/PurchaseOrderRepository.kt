package order.repository

interface PurchaseOrderRepository {

    fun getNextId(): Int

}