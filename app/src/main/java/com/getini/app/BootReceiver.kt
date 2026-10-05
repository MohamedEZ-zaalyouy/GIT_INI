package com.getini.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED ||
            intent?.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {

            // Android peut encore être en train de monter le stockage.
            // On attend quelques secondes avant la copie.
            Handler(Looper.getMainLooper()).postDelayed({
                IniCopier.copyIni(context.applicationContext)
            }, 10_000)
        }
    }
}
