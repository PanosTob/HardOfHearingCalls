package gr.dipae.hardofhearingcalls.framework.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import gr.dipae.hardofhearingcalls.data.user.UserDataSource
import gr.dipae.hardofhearingcalls.data.user.login.LoginRequest
import gr.dipae.hardofhearingcalls.data.user.register.RegistrationRequest
import gr.dipae.hardofhearingcalls.domain.user.entity.UserProfile
import gr.dipae.hardofhearingcalls.utils.*
import gr.dipae.hardofhearingcalls.utils.ext.BaseException
import gr.dipae.hardofhearingcalls.utils.ext.firebaseCall
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val mAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
) : UserDataSource {

    /*override suspend fun authorizeUser(): ResultWrapper<AuthorizationResponse> {
        return mAuth.currentUser?.let {
            ResultWrapper.Success(AuthorizationResponse(200, R.string.register_success, it.uid))

        } ?: ResultWrapper.Failure(
            BaseException(
                AUTHENTICATION_ERROR_CODE
            )
        )
    }*/

    override suspend fun updateUUID(userId: String, uuid: String) {
        if (!userAlreadyExists(userId)) {
            firebaseCall {
                saveNewUuid(userId, uuid)
            }
        }
    }

    override suspend fun registerUser(request: RegistrationRequest) {
        if (request.username == null || request.password == null) {
            throw BaseException(INVALID_PAYLOAD)
        }
        firebaseCall {
            mAuth.createUserWithEmailAndPassword(request.username, request.password).await()
            saveUser(
                UserProfile(
                    request.username,
                    request.firstName,
                    request.lastName,
                    request.uuid
                )
            )
        }
    }

    override suspend fun loginUser(request: LoginRequest) {
        if (request.username == null || request.password == null) {
            throw BaseException(AUTHENTICATION_ERROR_CODE)
        }
        firebaseCall {
            mAuth.signInWithEmailAndPassword(request.username, request.password).await()
        }
    }

    private suspend fun saveNewUuid(userId: String, uuid: String): Any {
        mAuth.currentUser?.let {
            return firebaseCall {
                firebaseFirestore.collection(USERS_TABLE).document(userId)
                    .update(USER_DEVICE_ID_KEY, uuid).await()
            }
        } ?: throw BaseException(AUTHENTICATION_ERROR_CODE)
    }

    private suspend fun saveUser(user: UserProfile): Any {
        if (user.username == null || user.uuid == null) {
            throw BaseException(INVALID_PAYLOAD)
        }
        mAuth.currentUser?.let {
            return firebaseCall {
                if (!userAlreadyExists(user.username)) {
                    firebaseFirestore.collection(USERS_TABLE).document(it.uid)
                        .set(
                            hashMapOf(
                                USER_USERNAME_KEY to user.username,
                                USER_FIRSTNAME_KEY to user.firstName,
                                USER_LASTNAME_KEY to user.lastName,
                                USER_DEVICE_ID_KEY to user.uuid
                            )
                        ).await()
                } else {
                    USER_ALREADY_EXISTS_CODE
                }
            }
        } ?: throw BaseException(AUTHENTICATION_ERROR_CODE)
    }

    private suspend fun userAlreadyExists(userId: String): Boolean {
        return firebaseCall {
            val userDoc = firebaseFirestore.collection(USERS_TABLE).document(userId).get(Source.SERVER).await()
            userDoc.exists()
        }
    }
}