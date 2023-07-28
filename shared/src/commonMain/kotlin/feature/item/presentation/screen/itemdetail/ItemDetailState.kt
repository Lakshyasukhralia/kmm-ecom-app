package feature.item.presentation.screen.itemdetail

import feature.item.domain.model.Item

data class ItemDetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val items: List<Item>? = emptyList(),
)
