package feature.profile.presentation.screen.profile

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import feature.profile.domain.repository.ProfileRepository
import feature.profile.presentation.screen.profile.ProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileViewModel : ViewModel(), KoinComponent {

    private val profileRepository by inject<ProfileRepository>()

    private var _uiState = MutableStateFlow(ProfileState())
    val uiState = _uiState.asStateFlow()

    private fun apiCall() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            profileRepository.callApi()
                .onSuccess { result ->
                    _uiState.update {
                        it.copy(
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
