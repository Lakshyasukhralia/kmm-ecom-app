package feature.order.presentation.screen.orderlisting

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import feature.order.domain.repository.OrderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class OrderListingViewModel : ViewModel(), KoinComponent {

    private val orderRepository by inject<OrderRepository>()

    private var _uiState = MutableStateFlow(OrderListingState())
    val uiState = _uiState.asStateFlow()

    init {
        getAllOrders()
    }

    private fun getAllOrders() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            orderRepository.getAllOrders()
                .onSuccess { items ->
                    _uiState.update {
                        it.copy(
                            orders = items,
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
