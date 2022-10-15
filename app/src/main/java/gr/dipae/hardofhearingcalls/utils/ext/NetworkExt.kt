package gr.dipae.hardofhearingcalls.utils.ext

import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestoreException
import gr.dipae.hardofhearingcalls.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

suspend fun <T : Any> firebaseCall(
    function: suspend () -> T
): T {
    return withContext(Dispatchers.IO) {
        try {
            function.invoke()
        } catch (exception: Exception) {
            Timber.tag("HardOfHearingCalls").e(exception)
            when (exception) {
                is FirebaseNetworkException -> throw BaseException(code = NETWORK_ERROR_CODE)
                is FirebaseFirestoreException -> throw NoInternetException()
                is FirebaseAuthInvalidUserException -> throw BaseException(code = INVALID_LOGIN_CREDENTIALS)
                is FirebaseAuthInvalidCredentialsException -> throw BaseException(code = INVALID_LOGIN_CREDENTIALS)
                is FirebaseAuthWeakPasswordException -> throw BaseException(code = PASSWORD_WEAK_CODE, message = exception.message.toString())
                is FirebaseAuthUserCollisionException -> throw BaseException(code = USER_ALREADY_EXISTS_CODE)
                is FirebaseTooManyRequestsException -> throw BaseException(code = TEMPORAL_BLOCKED_ERROR_CODE)
                is FirebaseException -> throw BaseException(code = API_CANT_BE_REACHED)
                is BaseException -> throw exception
                else -> throw BaseException(APPLICATION_ERROR_CODE)
            }
        }
    }
}