package gr.dipae.hardofhearingcalls.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gr.dipae.hardofhearingcalls.data.agora.AgoraIoDataSource
import gr.dipae.hardofhearingcalls.data.agora.AgoraIoRepositoryImpl
import gr.dipae.hardofhearingcalls.domain.AgoraIoRepository
import gr.dipae.hardofhearingcalls.framework.agora.AgoraIoDataSourceImpl
import gr.dipae.hardofhearingcalls.utils.APP_ID
import io.agora.rtc2.RtcEngine
import io.agora.rtc2.RtcEngineConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AgoraIoModule {

    @Provides
    @Singleton
    fun provideMRtcEngine(@ApplicationContext context: Context): RtcEngine {
        val config = RtcEngineConfig()
        config.mAppId = APP_ID
        config.mContext = context
        return RtcEngine.create(config)
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