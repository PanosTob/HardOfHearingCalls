package gr.dipae.hardofhearingcalls.domain.user.entity

data class UserProfile(
    val id: String? = null,
    val email: String? = null,
    val password: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    var uuid: String? = null
)