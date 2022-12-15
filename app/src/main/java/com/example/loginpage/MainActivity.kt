package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newUser = findViewById<TextView>(R.id.new_user)
        val forgotPassword = findViewById<TextView>(R.id.forgot_password)
        val loggedin = findViewById(R.id.login_button) as Button
        val userIdEmailPhone = findViewById<TextInputEditText>(R.id.user_id)
        val userPassword = findViewById<TextInputEditText>(R.id.user_password)

        loggedin.setOnClickListener(){
            var idEmailOrPhone: String = userIdEmailPhone.text.toString()
            var inputPassword: String = userPassword.text.toString()
            if (idEmailOrPhone == null || idEmailOrPhone.trim() == "" || inputPassword == null || inputPassword.trim() == ""){
                if (idEmailOrPhone == null || idEmailOrPhone.trim() == ""){
                    userIdEmailPhone.setError("Please enter a id")
                }
                if (inputPassword == null || inputPassword.trim() == ""){
                    userPassword.setError("Please enter a password")
                }
            }
            else
                Toast.makeText(this,"You are now logged in",Toast.LENGTH_SHORT).show()
        }

        newUser.setOnClickListener(){
            intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}