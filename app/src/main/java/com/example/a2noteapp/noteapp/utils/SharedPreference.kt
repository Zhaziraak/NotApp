package com.example.a2noteapp.noteapp.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {

        private lateinit var sharedPreference: SharedPreferences

        fun unit(context: Context) {
            sharedPreference = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
        }

        var title: String?
            get() = sharedPreference.getString("title", "")
            set(value) = sharedPreference.edit().putString("title", value)!!.apply()

        var isBoard: Boolean
            get() = sharedPreference.getBoolean("board", false)
            set(value) = sharedPreference.edit().putBoolean("board", value).apply()
}