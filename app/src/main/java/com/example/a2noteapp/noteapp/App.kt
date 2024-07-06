package com.example.a2noteapp.noteapp

import android.app.Application
import androidx.room.Room
import com.example.a2noteapp.noteapp.data.db.daos.AppDatabase
import com.example.a2noteapp.noteapp.utils.SharedPreference

class App: Application() {

    companion object{
    var appDatabase: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val sharedPreference = SharedPreference
        sharedPreference.unit(this)
        getInstance()
    }

    fun getInstance():AppDatabase? {
        if (appDatabase == null){
            appDatabase = applicationContext?.let{
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDatabase
    }
}