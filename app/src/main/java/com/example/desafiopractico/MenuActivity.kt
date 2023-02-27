package com.example.desafiopractico

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.example.desafiopractico.UserAppApplication.Companion.prefs

lateinit var titulo : TextView
lateinit var btnEjercicio1 : Button
lateinit var btnEjercicio2 : Button
lateinit var btnCerrarSesion:Button

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        titulo = findViewById(R.id.txtBienvenido)
        btnEjercicio1 = findViewById(R.id.btnEjercicio1)
        btnEjercicio2 = findViewById(R.id.btnEjercicio2)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        initUI()
        goToEjercicio1()
        goToEjercicio2()
    }

    fun initUI(){
        btnCerrarSesion.setOnClickListener{
            prefs.wipe()
            onBackPressed()
        }
        val userName = prefs.getName()
        titulo.text = "Bienvenido $userName"
    }

    fun goToEjercicio1(){
        btnEjercicio1.setOnClickListener{
            startActivity(Intent(this, Ejercicio1::class.java))
        }
    }
    fun goToEjercicio2(){
        btnEjercicio2.setOnClickListener{
            startActivity(Intent(this, Ejercicio2::class.java))
        }
    }
}
