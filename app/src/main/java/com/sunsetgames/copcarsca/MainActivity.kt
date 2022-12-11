package com.sunsetgames.copcarsca

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.firebase.database.*
import com.orhanobut.hawk.Hawk
import com.sunsetgames.copcarsca.files.Conist.Companion.QpsapspapPSApspap
import com.sunsetgames.copcarsca.files.Conist.Companion.XKkaskpAPSppsapspa
import com.sunsetgames.copcarsca.files.Conist.Companion.chekkkkksollllllasd
import com.sunsetgames.copcarsca.files.Conist.Companion.linnnnikkkekersa
import com.sunsetgames.copcarsca.files.Conist.Companion.poollllaskkkkawq

import com.sunsetgames.copcarsca.databinding.ActivityMainBinding
import com.sunsetgames.copcarsca.gorilsgr.DvesGas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var bindMainAct: ActivityMainBinding

    var firebaseDatabase: FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMainAct = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainAct.root)


        DepppppppppppppppppppSA(this)
        GlobalScope.launch(Dispatchers.IO) {
            job
        }

        AppsFlyerLib.getInstance()
            .init("KksHzTcaoMLbzqzBorVKNh", conversionDataListener, applicationContext)
        AppsFlyerLib.getInstance().start(this)


    }


    private val job: Job = GlobalScope.launch(Dispatchers.IO) {
        getData()

        val deeplink: String? = Hawk.get(XKkaskpAPSppsapspa, "null")

        val appsCh = Hawk.get(chekkkkksollllllasd, "null")
        Log.d("Appt",appsCh)
        var naming: String? = Hawk.get(poollllaskkkkawq)
        getAdId()
        if (appsCh == "1") {
            val executorService = Executors.newSingleThreadScheduledExecutor()
            executorService.scheduleAtFixedRate({
                if (naming != null) {
                    Log.d("TestInUIHawk", naming.toString())


                    if (naming!!.contains("tdb2") || deeplink!!.contains("tdb2")) {
                        Log.d("Apps Checker", "naming: $naming")
                        executorService.shutdown()
                        startActivity(Intent(this@MainActivity, TresSui::class.java))
                        finish()
                    } else {
                        executorService.shutdown()
                        startActivity(Intent(this@MainActivity, TresSui::class.java))
                        finish()
                    }
                } else {
                    naming = Hawk.get(poollllaskkkkawq)
                    Log.d("TestInUIHawk", "Received null $naming")
                }

            }, 0, 2, TimeUnit.SECONDS)
        } else {
            startActivity(Intent(this@MainActivity, TresSui::class.java))
            finish()
        }
    }


    private fun getAdId() {
        val adInfo = AdvertisingIdClient(applicationContext)
        adInfo.start()
        val adIdInfo = adInfo.info.id
        Log.d("getAdvertisingId = ", adIdInfo.toString())
        Hawk.put(QpsapspapPSApspap, adIdInfo)
    }


    fun DepppppppppppppppppppSA(Slxsapdpaspdp: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            Slxsapdpaspdp
        ) { TasdpppppppASD: AppLinkData? ->
            TasdpppppppASD?.let {
                val params = TasdpppppppASD.targetUri.host.toString()
                Hawk.put(XKkaskpAPSppsapspa, params)
                Log.e("dev_test", Hawk.get(XKkaskpAPSppsapspa));
            }
            if (TasdpppppppASD == null) {
                Log.e("dev_test", "1")
            }
        }
    }


    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val ASpdskdkskakdAASDoo = data?.get("campaign").toString()
            Hawk.put(poollllaskkkkawq, ASpdskdkskakdAASDoo)
            Log.e("dev_test", Hawk.get(poollllaskkkkawq))
        }

        override fun onConversionDataFail(p0: String?) {
            Log.e("dev_test", "error getting conversion data: $p0");
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }


    private fun getData() {
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase?.getReference("sara")
        databaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Clarnet", "Data : $snapshot")
                val app=snapshot.child("check").value.toString()
                val link=snapshot.child("link").value.toString()
                Hawk.put(chekkkkksollllllasd, app)
                Hawk.put(linnnnikkkekersa, link)


            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Fire", "Cancel")
            }

        })
    }
}
