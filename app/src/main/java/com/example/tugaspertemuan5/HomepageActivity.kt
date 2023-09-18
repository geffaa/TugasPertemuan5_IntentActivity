package com.example.tugaspertemuan5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tugaspertemuan5.RegisterActivity.Companion.EXTRA_USERNAME
import com.example.tugaspertemuan5.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data

                val username = data?.getStringExtra(EXTRA_USERNAME)
                val email = data?.getStringExtra(RegisterActivity.EXTRA_EMAIL)
                val phone = data?.getStringExtra(RegisterActivity.EXTRA_PHONE)

                if (!username.isNullOrEmpty() && !email.isNullOrEmpty() && !email.isNullOrEmpty()) {
                    binding.txtUsername.text = "$username"
                    binding.txtEmail.text = "$email"
                    binding.txtPhone.text = "$phone"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(RegisterActivity.EXTRA_EMAIL)
        val phone = intent.getStringExtra(RegisterActivity.EXTRA_PHONE)

        with(binding){

            binding.txtUsername.text = "$username"
            binding.txtEmail.text = "$email"
            binding.txtPhone.text = "$phone"

            btnLogout.setOnClickListener{
                finish()
            }

        }
    }
}