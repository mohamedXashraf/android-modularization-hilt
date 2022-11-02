package com.celfocus.data.repository

import com.celfocus.data.api.UserAPIs
import com.celfocus.data.base.Repository
import com.celfocus.domain.repository.UserRepository
import com.celfocus.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImplementation @Inject constructor(): Repository(), UserRepository {

    private val apis = retrofit().create(UserAPIs::class.java)

    override suspend fun getUsers(): MutableList<User> {
        val response  = apis.users()
        return response.data.ifEmpty { mutableListOf() }
    }
}