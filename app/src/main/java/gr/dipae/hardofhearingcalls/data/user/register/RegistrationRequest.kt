package gr.dipae.hardofhearingcalls.data.user.register

data class RegistrationRequest(
    val username: String?,
    val password: String?,
    val firstName: String?,
    val lastName: String?,
    var uuid: String?
)