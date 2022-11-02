package com.celfocus.domain.usecase

import com.celfocus.domain.repository.UserRepository
import com.celfocus.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetUsersTest
{
    private lateinit var getUsers: GetUsers
    private lateinit var repository: UserRepository
    private val users = mutableListOf(
        User(id = 0, email = "m@gmail.com"),
        User(id = 1, email = "s@gmail.com"),
        User(id = 2, email = "a@gmail.com"),
        User(id = 3, email = "w@gmail.com"),
    )

    @Before
    fun init()
    {
        repository = Mockito.mock(UserRepository::class.java)
        getUsers = GetUsers(repository)
    }

    @Test
    fun testGetUsersProcess()
    {
        runBlocking {
            Mockito.`when`(repository.getUsers()).thenReturn(users)

            val actualResult = getUsers.run()
            Assert.assertEquals(4, actualResult.size)
        }
    }
}