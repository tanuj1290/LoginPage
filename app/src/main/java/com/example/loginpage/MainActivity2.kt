package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val signUpButtonClicked = findViewById<Button>(R.id.signup_button)

        signUpButtonClicked.setOnClickListener(){
            Toast.makeText(this,"You are Successfully Signed Up",Toast.LENGTH_SHORT).show()
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}