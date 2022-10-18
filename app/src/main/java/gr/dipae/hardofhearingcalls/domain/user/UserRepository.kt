package gr.dipae.hardofhearingcalls.domain.user

import gr.dipae.hardofhearingcalls.data.user.login.LoginRequest
import gr.dipae.hardofhearingcalls.data.user.register.RegistrationRequest

interface UserRepository {
    suspend fun updateUUID(userId: String, uuid: String)
    suspend fun registerUser(request: RegistrationRequest)
    suspend fun loginUser(request: LoginRequest)
}