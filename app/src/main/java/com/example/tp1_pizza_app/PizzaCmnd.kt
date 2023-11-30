package com.example.tp1_pizza_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.tp1_pizza_app.databinding.ActivityPizzaCmndBinding

class PizzaCmnd : AppCompatActivity() {
    lateinit var binding: ActivityPizzaCmndBinding
    lateinit var size: String
    lateinit var ingredients: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPizzaCmndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstname = intent.getStringExtra("firstname")
        val lastname = intent.getStringExtra("lastname")
        val adresse = intent.getStringExtra("adresse")

        val radiogrp = binding.radioGroup
        val ingredientsgrp = binding.ingredients

        radiogrp.setOnCheckedChangeListener { _, checkedId ->
           val checkedsize:RadioButton= findViewById(checkedId)
            size = checkedsize.text.toString()
        }

        ingredientsgrp.setOnCheckedChangeListener { _, checkedId ->
            val checkedingredients:RadioButton= findViewById(checkedId)
            ingredients = checkedingredients.text.toString()
        }

        binding.sendCommand.setOnClickListener {

            val sms = "Bonjour $firstname $lastname, votre commande de pizza $size $ingredients sera livrée à $adresse"
            val uri = Uri.parse("smsto:5556")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", sms)
            startActivity(intent)

        }
    }
}