package feature.profile.data.repository

import feature.profile.data.remote.api.ProfileApi
import feature.profile.domain.repository.ProfileRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileRepositoryImpl : ProfileRepository, KoinComponent {

    private val api by inject<ProfileApi>()

    override suspend fun callApi(): Result<Any> {
        return try {
            val response = api.callApi()
            Result.success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}