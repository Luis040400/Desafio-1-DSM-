package com.example.desafiopractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.desafiopractico.UserAppApplication.Companion.prefs

lateinit var nombre : EditText
lateinit var contraseña : EditText
lateinit var btnIniciar : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nombre = findViewById(R.id.txtNombre)
        contraseña = findViewById(R.id.txtContraseña)
        btnIniciar = findViewById(R.id.btnIniciar)
        initUI()
        checkUserValues()
    }

    fun checkUserValues(){
        if(prefs.getName().isNotEmpty() && prefs.getPassword().isNotEmpty()){
            goToMenu()
        }
    }

    fun initUI(){
        btnIniciar.setOnClickListener {
            accessToDetail()
        }
    }

    fun accessToDetail(){
        if(nombre.text.toString().isNotEmpty() && contraseña.text.toString().isNotEmpty()){
            prefs.saveName(nombre.text.toString())
            prefs.saveContraseña(contraseña.text.toString())
            goToMenu()
        }else{
            Toast.makeText(this, "Error de autenticación",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun goToMenu(){
        startActivity(Intent(this, MenuActivity::class.java))
    }
}