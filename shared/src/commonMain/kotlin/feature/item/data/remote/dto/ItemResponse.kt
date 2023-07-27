package feature.item.data.remote.dto

import feature.item.domain.model.Item
import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
    val id: String,
    val name: String,
    val description: String,
    val price: Float? = null,
)

fun ItemResponse.toItem(): Item = Item(id, name, description, price ?: 0f)