package com.example.tugaspertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

            val btnLogout = findViewById<Button>(R.id.btn_logout)
            btnLogout.setOnClickListener {
                // Membuat Intent untuk kembali ke halaman login (LoginpageActivity)
                val intentToRegisterActivity = Intent(this@HomepageActivity, RegisterActivity::class.java)

                // Menambahkan flag untuk menghapus semua activity sebelumnya (agar tidak dapat kembali)
                intentToRegisterActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                // Memulai aktivitas (kembali ke halaman login)
                startActivity(intentToRegisterActivity)
            }

        }
    }
}