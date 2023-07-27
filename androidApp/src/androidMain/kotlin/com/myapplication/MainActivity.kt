package com.myapplication

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import core.di.initKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin(
            enableNetworkLogs = BuildConfig.DEBUG
        ) {
//            androidContext(applicationContext)
        }
        setContent {
            MainView()
        }
    }
}