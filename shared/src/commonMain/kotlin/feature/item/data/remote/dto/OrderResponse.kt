package feature.item.data.remote.dto

import feature.item.domain.model.Order
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderResponse(
    val id: String,
    @SerialName("product_id")
    val productId: String,
    val name: String,
    val description: String,
    val price: Float? = null,
    val date: String,
)

fun OrderResponse.toOrder(): Order = Order(id, productId, name, description, price ?: 0f, date)