package com.strinch.myapplicationmar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var campoNombre:EditText?=null
    var campoMateria:EditText?=null
    var nota1:EditText?=null
    var nota2:EditText?=null
    var nota3:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre = findViewById(R.id.name)
        campoMateria = findViewById(R.id.nameMat)
        nota1 = findViewById(R.id.n1)
        nota2= findViewById(R.id.n2)
        nota3= findViewById(R.id.n3)

        val btnCalcular: Button = findViewById(R.id.btnCalculo)
        btnCalcular.setOnClickListener { onClick() }
    }

    private fun onClick() {
        val intent= Intent(this,OtherWindow::class.java)
        val miBundle: Bundle = Bundle()
        miBundle.putString("Nombre",campoNombre!!.text.toString())
        miBundle.putString("Materia",campoMateria!!.text.toString())
        miBundle.putString("Nota1",nota1!!.text.toString())
        miBundle.putString("Nota2",nota2!!.text.toString())
        miBundle.putString("Nota3",nota3!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
    }
}