package com.example.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.home.BaseApplication
import com.example.home.R
import com.example.home.databinding.ActivityMainBinding
import com.example.home.viewmodel.MainViewModel
import com.example.home.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as BaseApplication).applicationComponent.inject(this)

        val viewModelMap = (application as BaseApplication).applicationComponent.getViewModelMap()

        viewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        viewModel.productsLiveData.observe(
            this,
            Observer {
                binding.tvMain.text = it.joinToString { x-> x.title + "\n\n" }
            }
        )
    }
}