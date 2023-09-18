package com.example.tugaspertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Homepage2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage2)

        // Ambil username dari intent dan tampilkan di TextView (seperti yang sudah Anda lakukan)

        val txtUsername = findViewById<TextView>(R.id.txt_username)
        val username = intent.getStringExtra(RegisterActivity.EXTRA_USERNAME)
        txtUsername.text = "$username" // Menampilkan pesan selamat datang dengan username

        // Mengatur onClickListener untuk tombol logout
        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            // Membuat Intent untuk kembali ke halaman login (LoginpageActivity)
            val intentToLogin = Intent(this@Homepage2Activity, LoginpageActivity::class.java)

            // Menambahkan flag untuk menghapus semua activity sebelumnya (agar tidak dapat kembali)
            intentToLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            // Memulai aktivitas (kembali ke halaman login)
            startActivity(intentToLogin)
        }
    }
}
