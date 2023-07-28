package feature.order.domain.model

data class Order(
    val id: String,
    val productId: String,
    val name: String,
    val description: String,
    val price: Float,
    val date: String,
)