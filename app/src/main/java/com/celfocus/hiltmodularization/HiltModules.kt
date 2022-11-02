package com.celfocus.hiltmodularization

import com.celfocus.data.repository.UserRepositoryImplementation
import com.celfocus.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltRepositoryModule {

    @Binds
    @Singleton
    abstract fun provideUserRepository(repository: UserRepositoryImplementation): UserRepository
}

//@Module
//@InstallIn(SingletonComponent::class)
//class HiltRepositoryModule {
//
//    @Provides
//    @Singleton
//    fun provideUserRepository(retrofit: Retrofit): UserRepository = UserRepositoryImplementation(retrofit)
//}

@Module
@InstallIn(SingletonComponent::class)
class HiltGeneralModule {

}