package feature.order.presentation.screen.orderlisting

import feature.order.domain.model.Order

data class OrderListingState(
    val isLoading: Boolean = false,
    val error: String = "",
    val orders: List<Order>? = emptyList(),
)
