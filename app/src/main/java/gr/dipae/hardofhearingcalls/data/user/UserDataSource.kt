package gr.dipae.hardofhearingcalls.data.user

interface UserDataSource {
    suspend fun updateUUID(userId: String?, uuid: String)
}