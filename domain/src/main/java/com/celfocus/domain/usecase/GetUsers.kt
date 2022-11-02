package com.celfocus.domain.usecase

import com.celfocus.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUsers @Inject constructor(private val repository: UserRepository) {

    suspend fun run() = repository.getUsers()
}