package feature.item.presentation.screen.itemdetail

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import feature.item.domain.repository.ItemRepository
import feature.item.presentation.screen.itemlisting.ItemListingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ItemDetailViewModel : ViewModel(), KoinComponent {

    private val itemRepository by inject<ItemRepository>()

    private var _uiState = MutableStateFlow(ItemListingState())
    val uiState = _uiState.asStateFlow()

    private fun checkout() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            itemRepository.getAllItems()
                .onSuccess { items ->
                    _uiState.update {
                        it.copy(
                            items = items,
                            error = "",
                            isLoading = false
                        )
                    }
                }
                .onFailure { e ->
                    _uiState.update {
                        it.copy(
                            error = e.message.toString(),
                            isLoading = false
                        )
                    }
                }
        }
    }
}
