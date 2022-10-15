package gr.dipae.hardofhearingcalls.domain.user

interface UserRepository {
    suspend fun updateUUID(userId: String?, uuid: String)
}