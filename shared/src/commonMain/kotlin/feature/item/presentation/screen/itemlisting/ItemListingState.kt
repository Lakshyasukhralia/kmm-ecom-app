package feature.item.presentation.screen.itemlisting

import feature.item.domain.model.Item

data class ItemListingState(
    val isLoading: Boolean = false,
    val error: String = "",
    val items: List<Item>? = emptyList(),
)
