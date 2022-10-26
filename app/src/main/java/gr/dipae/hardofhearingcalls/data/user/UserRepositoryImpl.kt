package gr.dipae.hardofhearingcalls.data.user

import gr.dipae.hardofhearingcalls.data.agora.AgoraIoDataSource
import gr.dipae.hardofhearingcalls.data.user.login.LoginRequest
import gr.dipae.hardofhearingcalls.data.user.register.RegistrationRequest
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import gr.dipae.hardofhearingcalls.domain.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {
    override suspend fun updateUUID(uuid: String) {
        dataSource.updateUUID(uuid)
    }

    override suspend fun registerUser(request: RegistrationRequest) {
        dataSource.registerUser(request)
    }

    override suspend fun loginUser(request: LoginRequest) {
        dataSource.loginUser(request)
    }
}