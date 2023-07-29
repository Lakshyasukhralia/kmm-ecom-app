package feature.profile.domain.model

data class User(
    val name: String,
    val phoneNumber: String? = null,
    val email: String? = null
)