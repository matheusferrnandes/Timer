package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var timer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editvalue)
        val btnstart: Button = findViewById(R.id.btnstart)
        val btnstop: Button = findViewById(R.id.btnstop)
        val result: TextView = findViewById(R.id.result)

        btnstart.setOnClickListener{
           try {
               val number = editText.text.toString().toLong()

               timer = object : CountDownTimer(number*60*1000, 1000){
                   override fun onTick(millisUntilFinished: Long) {
                       var segundos = millisUntilFinished / 1000
                       var minutos = segundos / 60
                       segundos = segundos % 60
                       result.text = String.format("%02d:%02d", minutos, segundos)
                   }

                   override fun onFinish() {
                      result.text = "O tempo acabou!"
                   }

               }
                  timer?.start()


           }

        catch(e: NumberFormatException){
            Toast.makeText(this,"Digite um numero",Toast.LENGTH_SHORT).show()
        }


    }
        btnstop.setOnClickListener{
             timer?.cancel()
        }

        }

    }
