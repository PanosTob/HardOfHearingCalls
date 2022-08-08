package gr.dipae.hardofhearingcalls.domain.lobby.entity

data class Contact(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val fcmToken: String
)