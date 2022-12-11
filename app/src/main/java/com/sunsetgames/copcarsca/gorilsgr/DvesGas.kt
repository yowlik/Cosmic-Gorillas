package com.sunsetgames.copcarsca.gorilsgr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.sunsetgames.copcarsca.R
import com.sunsetgames.copcarsca.databinding.ActivityDvesGasBinding

class DvesGas : AppCompatActivity() {
    lateinit var gorilBind:ActivityDvesGasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gorilBind= ActivityDvesGasBinding.inflate(layoutInflater)
        setContentView(gorilBind.root)



        val GorilBut= arrayListOf<ImageView>(gorilBind.gorilla1,gorilBind.gorilla2,gorilBind.gorilla3,gorilBind.gorilla4,gorilBind.gorilla5,
            gorilBind.gorilla6,gorilBind.gorilla7,gorilBind.gorilla8,gorilBind.gorilla9)
        val gorilla= arrayListOf<Int>(
            R.drawable.gorilasbanana,
            R.drawable.gorilasbanana,
            R.drawable.gorilasbanana,
            R.drawable.gorilasbanana,
            R.drawable.gorilasbanana,
            R.drawable.gorilasgoril,
            R.drawable.gorilasgoril,
            R.drawable.gorilasgoril,
            R.drawable.gorilasgoril
        )
        var resu=0
        var atts=5
        gorilla.shuffle()








        for(i in 0..8){
            GorilBut[i].setOnClickListener {
                atts--
                gorilBind.resusfacts.text="$atts Attemps"
                GorilBut[i].setBackgroundResource(gorilla[i])
                if(gorilla[i]== R.drawable.gorilasgoril){
                    resu++
                    if(resu==3){
                        val intent= Intent(this@DvesGas,GasWin::class.java)
                        startActivity(intent)

                    }
                }
                if(atts==0){
                    val intent= Intent(this@DvesGas,GasLose::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}