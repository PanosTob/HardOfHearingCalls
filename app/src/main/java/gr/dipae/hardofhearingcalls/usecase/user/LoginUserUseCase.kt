package gr.dipae.hardofhearingcalls.usecase.user

import gr.dipae.hardofhearingcalls.data.user.login.LoginRequest
import gr.dipae.hardofhearingcalls.domain.onboarding.entity.LoginUserResult
import gr.dipae.hardofhearingcalls.domain.user.UserRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(request: LoginRequest): LoginUserResult {
        return try {
            repository.loginUser(request)
            LoginUserResult.SUCCESS
        } catch (ex: Exception) {
            LoginUserResult.FAILURE
        }
    }
}