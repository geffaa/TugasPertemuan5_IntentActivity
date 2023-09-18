package com.example.tugaspertemuan5

import com.example.tugaspertemuan5.ForgotPasswordActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tugaspertemuan5.databinding.ActivityLoginpageBinding

class LoginpageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginpageBinding

    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnLogin.setOnClickListener{

                val intentToHome = Intent(this@LoginpageActivity,Homepage2Activity::class.java)

                val username = edtUsername.text.toString()
                val password = edtPass.text.toString()

                intentToHome.putExtra(RegisterActivity.EXTRA_USERNAME, username)
                intentToHome.putExtra(RegisterActivity.EXTRA_PASSWORD, password)

                startActivity(intentToHome)
            }
        }

        val btnForgotPassword = findViewById<TextView>(R.id.btn_forgot_password)

        btnForgotPassword.setOnClickListener {
            val intentToForgotPassword = Intent(this@LoginpageActivity, ForgotPasswordActivity::class.java)
            startActivity(intentToForgotPassword)
        }
        val btnToRegister = findViewById<TextView>(R.id.btn_to_register)

            btnToRegister.setOnClickListener {
                val intentToRegister = Intent(this@LoginpageActivity, RegisterActivity::class.java)
                startActivity(intentToRegister)
            }

    }
}