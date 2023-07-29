package feature.profile.domain.repository


interface ProfileRepository {
    suspend fun callApi(): Result<Any>
}