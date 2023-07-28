package feature.item.presentation.screen.order

import feature.item.domain.model.Order

data class OrderListingState(
    val isLoading: Boolean = false,
    val error: String = "",
    val orders: List<Order>? = emptyList(),
)
