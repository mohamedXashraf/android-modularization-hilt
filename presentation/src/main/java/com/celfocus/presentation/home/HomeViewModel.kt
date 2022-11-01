package com.celfocus.presentation.home

import com.celfocus.domain.usecase.GetUsers
import com.celfocus.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getUsers: GetUsers) : BaseViewModel<HomeViewState, HomeViewIntents>() {

    init {
        observeIntents {
            when(it) {
                is HomeViewIntents.GetUsersIntent -> getUsers()
            }
        }
    }

    private fun getUsers() = CoroutineScope(Dispatchers.IO).launch {
        try {
            state.postValue(HomeViewState.DataState(getUsers.run()))
        } catch (ex: Exception) {
            state.postValue(HomeViewState.ErrorState(ex))
        }
    }
}