package gr.dipae.hardofhearingcalls.usecase.user

import gr.dipae.hardofhearingcalls.data.user.register.RegistrationRequest
import gr.dipae.hardofhearingcalls.domain.onboarding.entity.RegisterUserResult
import gr.dipae.hardofhearingcalls.domain.user.UserRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(request: RegistrationRequest): RegisterUserResult {
        return try {
            repository.registerUser(request)
            RegisterUserResult.SUCCESS
        } catch (ex: Exception) {
            RegisterUserResult.FAILURE
        }
    }
}