package com.celfocus.presentation.home

import com.celfocus.model.User

sealed class HomeViewState {
    class DataState(val users: MutableList<User>) : HomeViewState()
    class ErrorState(val error: Throwable) : HomeViewState()
}