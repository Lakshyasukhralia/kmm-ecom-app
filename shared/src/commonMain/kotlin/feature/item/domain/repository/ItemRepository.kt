package feature.item.domain.repository

import feature.item.domain.model.Item
import feature.item.domain.model.Order

interface ItemRepository {
    suspend fun getAllItems(): Result<List<Item>>
    suspend fun getAllOrders(): Result<List<Order>>
}