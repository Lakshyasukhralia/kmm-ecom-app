package feature.item.presentation.screen.itemlisting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import feature.item.domain.repository.ItemRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ItemListingViewModel : ViewModel(), KoinComponent {

    private val itemRepository by inject<ItemRepository>()
    var state by mutableStateOf(ItemListingState())

    init {
        getAllItems()
    }

    fun getAllItems() {
        viewModelScope.launch {
            itemRepository.getAllItems()
                .onSuccess { items ->
                    state = state.copy(
                        items = items,
                        error = ""
                    )
                }
                .onFailure { e ->
                    state = state.copy(
                        error = e.message.toString(),
                    )
                }
        }
    }
}