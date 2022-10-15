package gr.dipae.hardofhearingcalls.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gr.dipae.hardofhearingcalls.framework.agora.AgoraIoDataSourceImpl
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import gr.dipae.hardofhearingcalls.data.agora.AgoraIoDataSource
import gr.dipae.hardofhearingcalls.data.agora.AgoraIoRepositoryImpl
import gr.dipae.hardofhearingcalls.utils.APP_ID
import io.agora.rtc2.IRtcEngineEventHandler
import io.agora.rtc2.RtcEngine
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AgoraIoModule {

    @Provides
    @Singleton
    fun provideMRtcEngine(@ApplicationContext context: Context): RtcEngine {
        return RtcEngine.create(
            context,
            APP_ID,
            object: IRtcEngineEventHandler() {}
        )
    }
}

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AgoraIoBindsModule {
    @Binds
    fun bindAgoraIoRepository(repository: AgoraIoRepositoryImpl): AgoraIoRepository

    @Binds
    fun bindAgoraIoDataSource(dataSource: AgoraIoDataSourceImpl): AgoraIoDataSource
}