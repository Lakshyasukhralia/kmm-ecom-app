package feature.item.data.repository

import feature.item.data.remote.api.ItemApi
import feature.item.data.remote.dto.toItem
import feature.item.data.remote.dto.toOrder
import feature.item.domain.model.Item
import feature.item.domain.model.Order
import feature.item.domain.repository.ItemRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ItemRepositoryImpl : ItemRepository, KoinComponent {

    private val itemApi by inject<ItemApi>()

    override suspend fun getAllItems(): Result<List<Item>> {
        return try {
            val response = itemApi.getAllItems()
            Result.success(response.map { it.toItem() })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getAllOrders(): Result<List<Order>> {
        return try {
            val response = itemApi.getAllOrders()
            Result.success(response.map { it.toOrder() })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}