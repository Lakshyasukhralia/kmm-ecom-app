package feature.item.domain.repository

import feature.item.domain.model.Item

interface ItemRepository {
    suspend fun getAllItems(): Result<List<Item>>
}