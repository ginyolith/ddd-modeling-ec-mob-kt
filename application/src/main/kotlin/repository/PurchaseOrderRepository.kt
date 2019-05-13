package repository

interface PurchaseOrderRepository {

    fun getNextId(): Int

}