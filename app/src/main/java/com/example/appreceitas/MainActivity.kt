package com.example.appreceitas

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.login_email)
        password = findViewById(R.id.login_password)
        buttonLogin = findViewById(R.id.button_login)

        buttonLogin.setOnClickListener{
            if (
                email.text.toString().equals("teste@gmail.com") &&
                password.text.toString().equals("1234")
            ){
                Toast.makeText(this,"Carregando...",Toast.LENGTH_LONG).show()

                var intent = Intent(applicationContext, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Email ou Senha incorretos",Toast.LENGTH_LONG).show()
            }
        }
    }
}