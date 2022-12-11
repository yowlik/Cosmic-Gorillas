package com.sunsetgames.copcarsca.gorilsgr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sunsetgames.copcarsca.R

class GasWin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gas_win)




        val cos=findViewById<Button>(R.id.gorilresstart)






        cos.setOnClickListener {val ins= Intent(this@GasWin, DvesGas::class.java)
            startActivity(ins)}
    }
}