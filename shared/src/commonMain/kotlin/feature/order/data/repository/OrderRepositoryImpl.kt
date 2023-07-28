package feature.order.data.repository

import feature.item.data.remote.dto.toOrder
import feature.order.data.remote.api.OrderApi
import feature.order.domain.model.Order
import feature.order.domain.repository.OrderRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class OrderRepositoryImpl : OrderRepository, KoinComponent {

    private val api by inject<OrderApi>()

    override suspend fun getAllOrders(): Result<List<Order>> {
        return try {
            val response = api.getAllOrders()
            Result.success(response.map { it.toOrder() })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}