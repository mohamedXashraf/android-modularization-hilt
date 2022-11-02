package com.celfocus.presentation.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.celfocus.model.User
import com.celfocus.presentation.R
import com.celfocus.presentation.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.state.observe(this@HomeActivity) { setViewState(it) }

        init()
    }

    override fun onResume()
    {
        super.onResume()
        viewModel.intent.value = HomeViewIntents.GetUsersIntent
    }

    override fun onDestroy()
    {
        super.onDestroy()
        viewModel.clear()
    }

    private fun init() {
        adapter = UsersAdapter(this@HomeActivity) { Toast.makeText(this@HomeActivity, it.email, Toast.LENGTH_SHORT).show() }
        binding.users.setHasFixedSize(false)
        binding.users.isNestedScrollingEnabled = false
        binding.users.layoutManager = GridLayoutManager(this@HomeActivity, 2)
        // binding.users.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.users.adapter = adapter
        adapter.setData(mutableListOf())
    }

    private fun setViewState(state: HomeViewState)
    {
        when (state)
        {
            is HomeViewState.DataState -> setData(state.users)
            is HomeViewState.ErrorState -> showError(state.error.message ?: getString(R.string.error))
        }
    }

    private fun setData(users: MutableList<User>)
    {
        adapter.setData(users)
    }

    private fun showError(error: String)
    {
        Snackbar.make(binding.mainView, error, Snackbar.LENGTH_LONG).setAction(getString(R.string.ok)) { }.show()
    }
}