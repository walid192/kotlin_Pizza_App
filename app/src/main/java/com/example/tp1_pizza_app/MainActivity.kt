package com.example.tp1_pizza_app

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import com.example.tp1_pizza_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        var bottomAnim = AnimationUtils.loadAnimation(this, R.anim.botttom_animation)

         var logo = binding.imageView
         var appname = binding.appName
         var slogan = binding.textView2

        logo.animation = topAnim
        appname.animation = bottomAnim
        slogan.animation = bottomAnim


        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(5000)
                    val intent = Intent(baseContext, HomeApp::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()


    }


    
}