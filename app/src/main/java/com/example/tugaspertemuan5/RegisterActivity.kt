package com.example.tugaspertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tugaspertemuan5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
        const val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnRegister.setOnClickListener{

                val intentToHome = Intent(this@RegisterActivity,HomepageActivity::class.java)

                val username = edtUsername.text.toString()
                val email = edtEmail.text.toString()
                val phone = edtPhone.text.toString()
                val password = edtPass.text.toString()

                intentToHome.putExtra(EXTRA_USERNAME, username)
                intentToHome.putExtra(EXTRA_EMAIL, email)
                intentToHome.putExtra(EXTRA_PHONE, phone)
                intentToHome.putExtra(EXTRA_PASSWORD, password)

                startActivity(intentToHome)

            }
        }

            val btnToLogin = findViewById<TextView>(R.id.btn_to_login)

                btnToLogin.setOnClickListener {
                val intentToLogin = Intent(this@RegisterActivity, LoginpageActivity::class.java)
                startActivity(intentToLogin)
        }

    }
}