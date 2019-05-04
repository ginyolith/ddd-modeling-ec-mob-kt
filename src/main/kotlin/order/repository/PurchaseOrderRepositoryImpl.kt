package order.repository


class PurchaseOrderRepositoryImpl : PurchaseOrderRepository {
    private var _nextId: Int = 0

    override fun getNextId(): Int {
        _nextId++

        return _nextId
    }
}