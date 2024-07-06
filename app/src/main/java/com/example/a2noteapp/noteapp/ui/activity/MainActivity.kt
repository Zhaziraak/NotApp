package com.example.a2noteapp.noteapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.a2noteapp.R
import com.example.a2noteapp.databinding.ActivityMainBinding
import com.example.a2noteapp.noteapp.utils.SharedPreference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = NavHostFragment.navController

        if (SharedPreference.isBoard == true){
            navController.navigate(R.id.noteFragment)
        }else{
            navController.navigate(R.id.onBoardFragment)
        }
    }
}