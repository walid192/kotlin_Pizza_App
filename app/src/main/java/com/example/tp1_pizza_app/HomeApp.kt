package com.example.tp1_pizza_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.tp1_pizza_app.databinding.ActivityHomeAppBinding

class HomeApp : AppCompatActivity() {

    lateinit var binding: ActivityHomeAppBinding
    lateinit var firstname: EditText
    lateinit var lastname: EditText
    lateinit var adresse: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firstname = binding.firstname
        lastname = binding.lastname
        adresse = binding.adresse

        binding.addcommandbtn.setOnClickListener {
            if (firstname.text.toString().isNotEmpty() && lastname.text.toString()
                    .isNotEmpty() && adresse.text.toString().isNotEmpty()
            ) {
                val intent = Intent(this, PizzaCmnd::class.java)
                intent.putExtra("firstname", firstname.text.toString())
                intent.putExtra("lastname", lastname.text.toString())
                intent.putExtra("adresse", adresse.text.toString())
                startActivity(intent)
            } else {

                val toast = Toast.makeText(
                    applicationContext,
                    "Veuillez remplir tous les champs",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }

        }
    }
}