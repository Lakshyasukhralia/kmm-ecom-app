package feature.item.domain.repository

import feature.item.domain.model.Item
import feature.order.domain.model.Order

interface ItemRepository {
    suspend fun getAllItems(): Result<List<Item>>
}