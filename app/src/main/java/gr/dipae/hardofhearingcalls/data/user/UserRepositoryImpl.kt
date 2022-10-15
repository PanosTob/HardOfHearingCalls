package gr.dipae.hardofhearingcalls.data.user

import gr.dipae.hardofhearingcalls.data.agora.AgoraIoDataSource
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import gr.dipae.hardofhearingcalls.domain.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {
    override suspend fun updateUUID(userId: String?, uuid: String) {
        dataSource.updateUUID(userId, uuid)
    }
}