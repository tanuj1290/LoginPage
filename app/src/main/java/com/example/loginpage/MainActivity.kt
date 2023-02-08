package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=])" +  // at least 1 special character
                "(?=\\S+$)" +  // no white spaces
                ".{4,}" +  // at least 4 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val sharedp:SharedPreferences = this.getSharedPreferences(MainActivity2.sharedPrefFilename, MODE_PRIVATE)

        var temp_for_buttton_enabled_id: Boolean = false
        var temp_for_buttton_enabled_password: Boolean = false

        val newUser = findViewById<TextView>(R.id.new_user)
        val forgotPassword = findViewById<TextView>(R.id.forgot_password)
        val loggedin = findViewById(R.id.login_button) as Button
        val userIdEmailPhone = findViewById<TextInputEditText>(R.id.user_id)
        val userPassword = findViewById<TextInputEditText>(R.id.user_password)
        val userEmailContainer = findViewById<TextInputLayout>(R.id.user_email_container)
        val passwordContainer = findViewById<TextInputLayout>(R.id.password_container)

        val sharedPref: SharedPreferences = getSharedPreferences("MyLogin", MODE_PRIVATE)

        userIdEmailPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (Patterns.EMAIL_ADDRESS.matcher(userIdEmailPhone.text.toString())
                        .matches() || Patterns.PHONE.matcher(userIdEmailPhone.text.toString())
                        .matches()
                ) {
                    userEmailContainer.helperText = null
                    userEmailContainer.isHelperTextEnabled = false
//                    loggedin.isEnabled = true
                    temp_for_buttton_enabled_id = true
                } else {
                    userEmailContainer.helperText = "* Enter a valid ID"
//                    loggedin.isEnabled = false
                    temp_for_buttton_enabled_id = false
                }
                if (temp_for_buttton_enabled_id && temp_for_buttton_enabled_password)
                    loggedin.isEnabled = true
                else
                    loggedin.isEnabled = false
            }
        })

        userPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                var password: String = userPassword.text.toString()
                if (password.isEmpty()) {
                    passwordContainer.helperText = "Enter a password"
                    passwordContainer.isHelperTextEnabled = true
                    temp_for_buttton_enabled_password = false
                } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
                    passwordContainer.helperText = "Password is too weak"
                    passwordContainer.isHelperTextEnabled = true
                    temp_for_buttton_enabled_password = false
                } else {
                    passwordContainer.helperText = null
                    passwordContainer.isHelperTextEnabled = false
                    temp_for_buttton_enabled_password = true
                }


                if (temp_for_buttton_enabled_id && temp_for_buttton_enabled_password)
                    loggedin.isEnabled = true
                else
                    loggedin.isEnabled = false

            }
        })
        loggedin.setOnClickListener() {
//            var idEmailOrPhone: String = userIdEmailPhone.text.toString()
//            var inputPassword: String = userPassword.text.toString()
            var emailOrPhone = userIdEmailPhone.text.toString().trim()
            var password = userPassword.text.toString().trim()
            if ((sharedPref.getString("email", "") == emailOrPhone || sharedPref.getString("phone", "") == emailOrPhone) &&
                sharedPref.getString("password", "") == password) {
                Toast.makeText(this, "You are Succesfully logged in", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Incorrect Login Credentials", Toast.LENGTH_SHORT).show()
            }


        }

        newUser.setOnClickListener() {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}