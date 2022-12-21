package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val signUpButtonClicked = findViewById<Button>(R.id.signup_button)
        val namecontainer = findViewById<TextInputLayout>(R.id.name_container)
        val emailcontainer = findViewById<TextInputLayout>(R.id.email_container)
        val phonecontainer = findViewById<TextInputLayout>(R.id.phone_container)
        val password1container = findViewById<TextInputLayout>(R.id.password_1_container)
        val password2container = findViewById<TextInputLayout>(R.id.password_2_container)

        val nameEditTextSignup = findViewById<TextInputEditText>(R.id.name_editText)
        val emailEditTextSignup = findViewById<TextInputEditText>(R.id.email_editText)
        val phoneEditTextSignup = findViewById<TextInputEditText>(R.id.phone_editText)
        val password1EditText = findViewById<TextInputEditText>(R.id.password_1_edittext)
        val password2EditText = findViewById<TextInputEditText>(R.id.password_2_edittext)



        password2EditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (password2EditText.text.toString()
                        .isNotEmpty() && password1EditText.text.toString().isNotEmpty()
                ) {
                    if (password2EditText.text.toString()
                            .equals(password1EditText.text.toString())
                    ) {
                        signUpButtonClicked.isEnabled = true
                    } else
                        signUpButtonClicked.isEnabled = false
                } else
                    signUpButtonClicked.isEnabled = false
            }
        })


        signUpButtonClicked.setOnClickListener() {
            Toast.makeText(this, "You are Successfully Signed Up", Toast.LENGTH_SHORT).show()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}