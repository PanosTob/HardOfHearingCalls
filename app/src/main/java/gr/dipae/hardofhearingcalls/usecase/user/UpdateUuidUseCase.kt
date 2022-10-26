package gr.dipae.hardofhearingcalls.usecase.user

import gr.dipae.hardofhearingcalls.domain.onboarding.entity.UpdateUuidResult
import gr.dipae.hardofhearingcalls.domain.user.UserRepository
import javax.inject.Inject

class UpdateUuidUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(uuid: String): UpdateUuidResult {
        return try {
            repository.updateUUID(uuid)
            UpdateUuidResult.SUCCESS
        } catch (ex: Exception) {
            UpdateUuidResult.FAILURE
        }
    }
}