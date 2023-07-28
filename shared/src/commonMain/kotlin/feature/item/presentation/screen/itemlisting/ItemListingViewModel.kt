package feature.item.presentation.screen.itemlisting

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import feature.item.domain.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ItemListingViewModel : ViewModel(), KoinComponent {

    private val itemRepository by inject<ItemRepository>()

    private var _uiState = MutableStateFlow(ItemListingState())
    val uiState = _uiState.asStateFlow()

    init {
//        getAllItems()
    }

    fun getAllItems() {
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
