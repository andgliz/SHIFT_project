package com.example.shiftproject

import android.app.Application
import com.example.shiftproject.data.AppContainer
import com.example.shiftproject.data.AppDataContainer

class ShiftApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
