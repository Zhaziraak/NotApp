package com.example.a2noteapp.noteapp

import android.app.Application
import com.example.a2noteapp.noteapp.utils.SharedPreference

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreference = SharedPreference
        sharedPreference.unit(this)
    }
}