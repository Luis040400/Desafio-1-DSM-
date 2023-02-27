package com.example.desafiopractico

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

lateinit var rNombre : TextView
lateinit var rCodigo : TextView
lateinit var rVentas : TextView
lateinit var rMes : TextView
lateinit var rPComisiones : TextView
lateinit var rTotalVentas : TextView
lateinit var rComisiones : TextView
lateinit var btnVolver : Button

class ResultEjercicio2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_ejercicio2)
        rNombre = findViewById(R.id.txtNombre)
        rCodigo = findViewById(R.id.txtCodigo)
        rVentas = findViewById(R.id.txtVentas)
        rMes = findViewById(R.id.txtMes)
        rPComisiones = findViewById(R.id.txtPorComi)
        rTotalVentas = findViewById(R.id.txtTotal)
        rComisiones = findViewById(R.id.txtComisiones)
        btnVolver = findViewById(R.id.btnVolver)
        setData()
        goBack()
    }

    fun setData(){
        Log.d("LEGUE","LLEGUE")
        val nombre = intent.getStringExtra("nombre")
        val codigo = intent.getStringExtra("codigo")
        val ventas = intent.getStringExtra("ventas")
        val mes = intent.getStringExtra("mes")
        val ventasN = intent.getSerializableExtra("arregloVentas") as ArrayList<Double>
        var comisiones = 0.0
        var PorVentas = 0.0

        for (i in ventasN){
            PorVentas += i
            if(i > 500 && i < 1000){
                comisiones = i * 0.05
            }
            if(i>1000 && i<2000){comisiones += i * 0.1}
            if(i>2000 && i<3000){comisiones += i * 0.15}
            if(i>3000 && i<4000){comisiones += i*0.20}
            if(i>=4000){comisiones += i*0.30}
        }

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val resultado = df.format(comisiones)
        val totalPorComision = resultado.toDouble() * 100 / PorVentas
        val ComisionResultado = df.format(totalPorComision)
        val VentaResultado = df.format(PorVentas)
        rNombre.setText("Nombre: "+nombre)
        rCodigo.setText("Código: "+codigo)
        rVentas.setText("Ventas: "+ventas)
        rMes.setText("Mes: " + mes)
        rTotalVentas.setText("Total de ventas " + VentaResultado)
        rPComisiones.setText("Porcentaje de comisión total: %"+ ComisionResultado)
        rComisiones.setText("Comisiones: "+ resultado)
    }

    fun goBack(){
        btnVolver.setOnClickListener{
            onBackPressed()
        }
    }
}