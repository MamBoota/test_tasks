package com.example.focusstart_android_testtask.data

import android.app.Application
import androidx.emoji.bundled.BundledEmojiCompatConfig
import androidx.emoji.text.EmojiCompat
import androidx.room.Room

class App : Application() {

    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()

        val emojiConfig = BundledEmojiCompatConfig(this)
        emojiConfig.setReplaceAll(true)
            .registerInitCallback(object : EmojiCompat.InitCallback() {
                override fun onInitialized() {
//                    Timber.d( "EmojiCompat initialized")
                }

                override fun onFailed(throwable: Throwable?) {
//                    Timber.d("EmojiCompat initialization failed $throwable" )
                }
            })
        EmojiCompat.init(emojiConfig)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "db"
        )
            .build()
    }
}