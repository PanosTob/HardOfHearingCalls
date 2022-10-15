package gr.dipae.hardofhearingcalls.framework.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import gr.dipae.hardofhearingcalls.data.user.UserDataSource
import gr.dipae.hardofhearingcalls.utils.ext.firebaseCall
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val mAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
) : UserDataSource {
    override suspend fun updateUUID(userId: String?, uuid: String) {
        firebaseCall {
//            mAuth.createUserWithEmailAndPassword(request.email, request.password).await()
        }
    }
}