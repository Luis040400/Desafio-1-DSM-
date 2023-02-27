package com.example.desafiopractico

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

lateinit var txtA : EditText
lateinit var txtB : EditText
lateinit var txtC : EditText
lateinit var tvX1 : TextView
lateinit var tvX2 : TextView
lateinit var btnResultado : Button
lateinit var btnEj2Volver : Button
class Ejercicio2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
        txtA = findViewById(R.id.etA)
        txtB = findViewById(R.id.etB)
        txtC = findViewById(R.id.etC)
        tvX1 = findViewById(R.id.tvX1)
        tvX2 = findViewById(R.id.tvX2)
        btnEj2Volver = findViewById(R.id.btnEj2Volver)
        btnResultado = findViewById(R.id.btnCalcular)
        btnResultado.setOnClickListener{calculate()}
        btnEj2Volver.setOnClickListener{goToMenu()}
    }
    fun calculate(){
        if (txtA.text.toString().isNotEmpty() && txtB.text.toString().isNotEmpty() && txtC.text.toString().isNotEmpty()){
            val a = txtA.text.toString().toDouble()
            val b = txtB.text.toString().toDouble()
            val c = txtC.text.toString().toDouble()
            Log.d("VARIBLE A",a.toString())
            Log.d("VARIABLE B",b.toString())
            Log.d("VARIABLE C",c.toString())
            val discriminante = b * b - (4 * a * c)
            if(discriminante>0){
                val x1 = (-b + sqrt(discriminante))/(2*a)
                val x2 = (-b - sqrt(discriminante))/(2*a)
                tvX1.setText("Solución X1: " + x1)
                tvX2.setText("Solución X2: " + x2)
            }
            else if(discriminante == 0.0){
                val x = -b / (2*a)
                tvX1.setText("Solución X1: " + x)
                Toast.makeText(this, "Tiene una sola solución",
                    Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No tiene soluciones reales",
                    Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Todos los campos son requeridos",
                Toast.LENGTH_SHORT).show()
        }

    }
    fun goToMenu(){
        onBackPressed()
    }
}