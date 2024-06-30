package com.example.a2noteapp.noteapp

import android.app.Application
import com.example.a2noteapp.noteapp.utils.SharedPreference

 Lesson_3
class App:Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreference = SharedPreference

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreference = SharedPreference()
 master
        sharedPreference.unit(this)
    }
}