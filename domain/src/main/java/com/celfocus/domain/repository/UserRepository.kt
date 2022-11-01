package com.celfocus.domain.repository

import com.celfocus.model.User

interface UserRepository {
    suspend fun getUsers(): MutableList<User>
}