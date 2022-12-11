package com.sunsetgames.copcarsca.files

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import com.sunsetgames.copcarsca.files.Conist.Companion.finiminissignik


class Oners: Application()  {





    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(finiminissignik)

        Hawk.init(this).build()
    }




}