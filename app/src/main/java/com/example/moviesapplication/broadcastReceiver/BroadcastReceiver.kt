package com.example.moviesapplication.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadCastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state",false)
        if (isEnabled == true && context!=null){
            NotificationManager.notification(context,"There is no internet connection")
        }else{
            context?.let { NotificationManager.notification(it,"Internet connection restored") }
        }
    }
}