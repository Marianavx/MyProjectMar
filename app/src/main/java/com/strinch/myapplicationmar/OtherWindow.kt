package com.strinch.myapplicationmar

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class OtherWindow:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_window)

        val name = findViewById<TextView>(R.id.textName)
        val mat=findViewById<TextView>(R.id.textMat)
        val n1=findViewById<TextView>(R.id.note1)
        val n2=findViewById<TextView>(R.id.note2)
        val n3=findViewById<TextView>(R.id.note3)
        val promedio=findViewById<TextView>(R.id.prom)
        val estado=findViewById<TextView>(R.id.state)

        var miBundle: Bundle? = this.intent.extras
        if (miBundle != null){
            val nota1 =miBundle.getString("Nota1")!!.toDouble()
            val nota2 =miBundle.getString("Nota2")!!.toDouble()
            val nota3 =miBundle.getString("Nota3")!!.toDouble()
            if (nota1 < 0 || nota2 <0 || nota3 < 0 || nota1 >5 || nota2 >5 || nota3 >5){
                finish()
            }
            else{
                var prom= (nota1+nota2+nota3)/3
                name.text="Nombre:${miBundle.getString("Nombre")}"
                mat.text="Materia:${miBundle.getString("Materia")}"
                n1.text="Nota 1:${nota1}"
                n2.text="Nota 2:${nota2}"
                n3.text="Nota 3:${nota3}"
                promedio.text="Promedio:${prom}"

                if (prom >= 3.5){
                    estado.text="Estado: Aprobado"
                    estado.setTextColor(ContextCompat.getColor(this,R.color.Ganar))
                }
                else{
                    estado.text="Estado: Reprobado"
                    estado.setTextColor(ContextCompat.getColor(this,R.color.Perder))

                }

            }
            val botonSalir:Button=findViewById(R.id.btnSalir)
            botonSalir.setOnClickListener{onClick()}

        }
    }

    private fun onClick() {
        finish()
    }
}