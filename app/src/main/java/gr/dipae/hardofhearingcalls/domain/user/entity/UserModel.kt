package gr.dipae.hardofhearingcalls.domain.user.entity

data class UserProfile(
    val username: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    var uuid: String? = null
)