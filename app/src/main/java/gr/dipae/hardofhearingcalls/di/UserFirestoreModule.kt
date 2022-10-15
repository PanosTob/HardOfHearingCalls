package gr.dipae.hardofhearingcalls.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gr.dipae.hardofhearingcalls.data.user.UserDataSource
import gr.dipae.hardofhearingcalls.data.user.UserRepositoryImpl
import gr.dipae.hardofhearingcalls.domain.user.UserRepository
import gr.dipae.hardofhearingcalls.framework.user.UserDataSourceImpl
import gr.dipae.hardofhearingcalls.utils.HARD_OF_HEARING_PREFS
import gr.dipae.hardofhearingcalls.utils.encryptor.Encryptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    //Firebase
    @Provides
    @Singleton
    fun provideFirebaseFireStore(): FirebaseFirestore =
        FirebaseFirestore.getInstance()

    @Provides
    fun provideFirebaseAuthentication(): FirebaseAuth =
        FirebaseAuth.getInstance()
}

@Module
@InstallIn(ActivityRetainedComponent::class)
interface UserBindsModule {

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    fun bindUserDataSource(dataSource: UserDataSourceImpl): UserDataSource
}
