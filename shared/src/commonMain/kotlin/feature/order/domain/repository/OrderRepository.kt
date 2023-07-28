package feature.order.domain.repository

import feature.order.domain.model.Order


interface OrderRepository {
    suspend fun getAllOrders(): Result<List<Order>>
}