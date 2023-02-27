package com.example.desafiopractico

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.android.awaitFrame
import java.text.DecimalFormat

lateinit var txtNombre : EditText
lateinit var txtCodigo : EditText
lateinit var txtVentas : EditText
lateinit var spinner : Spinner
lateinit var button : Button
lateinit var button1 : Button
lateinit var btnEj1Volver : Button


class Ejercicio1 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        txtNombre =findViewById(R.id.txtNombre)
        txtCodigo = findViewById(R.id.txtCodigo)
        txtVentas = findViewById(R.id.txtVentas)
        spinner = findViewById(R.id.idSpinner)
        button = findViewById(R.id.button)
        button1 = findViewById(R.id.button1)
        btnEj1Volver = findViewById(R.id.btnEj1Volver)
        button.setOnClickListener{ejecutar()}
        button1.setOnClickListener{goToResult()}
        btnEj1Volver.setOnClickListener{goToMenu()}
    }
    var arreglo = ArrayList<Double>()

    @SuppressLint("SuspiciousIndentation")
    fun ejecutar(){
        if(txtNombre.text.toString().isNotEmpty() && txtCodigo.text.toString().isNotEmpty() && txtVentas.text.toString().isNotEmpty()){
                var times = txtVentas.text.toString().toInt()
                mostrarDialogs(times)
        }
        else{
            Toast.makeText(this, "Verificar no dejar campos vacíos",
                Toast.LENGTH_SHORT).show()
        }
    }
    fun mostrarDialogs(veces:Int){
        val builder = AlertDialog.Builder(this)
        val inflater: LayoutInflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.input_dialog,null)
        val editText = dialogLayout.findViewById<EditText>(R.id.txtCantidad)
        with(builder) {
            setTitle("Ingresa la venta")
            setPositiveButton("OK") { dialog, which ->
                arreglo.add(editText.text.toString().toDouble())
            }
            setNegativeButton("Cancelar"){dialog,which->
                Log.d("SALIO","SALIO")
            }
            setView(dialogLayout)
            setOnDismissListener{
                if(veces>1){
                    mostrarDialogs(veces-1)
                }else{
                    button.visibility = View.GONE
                    button1.visibility = View.VISIBLE
                }
            }
            show()
        }
    }
    fun goToResult(){
            if(arreglo.size == txtVentas.text.toString().toInt()){
                startActivity(Intent(this, ResultEjercicio2Activity::class.java).apply {
                    putExtra("nombre", txtNombre.text.toString())
                    putExtra("codigo", txtCodigo.text.toString())
                    putExtra("ventas", txtVentas.text.toString())
                    putExtra("mes", spinner.getSelectedItem().toString())
                    putExtra("arregloVentas",arreglo)
        })
                txtNombre.setText("")
                txtCodigo.setText("")
                txtVentas.setText("")
                arreglo.clear()
                button.visibility = View.VISIBLE
                button1.visibility = View.GONE
            } else{
                Toast.makeText(this, "Faltaron valores de ventas",
                    Toast.LENGTH_SHORT).show()
            }
    }
    fun goToMenu(){
        onBackPressed()
    }
}