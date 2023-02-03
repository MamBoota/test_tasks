package com.example.focusstart_android_testtask.presentation

import android.app.Application
import androidx.room.Room
import com.example.focusstart_android_testtask.data.AppDatabase

class App : Application() {

    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "db"
        )
            .build()
    }
}