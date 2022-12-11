package com.sunsetgames.copcarsca.gorilsgr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sunsetgames.copcarsca.R

class GasLose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gas_lose)

        val cos=findViewById<Button>(R.id.gorilstart)






        cos.setOnClickListener {val ins= Intent(this@GasLose, DvesGas::class.java)
            startActivity(ins)}
    }
}