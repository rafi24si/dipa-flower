package com.example.dipa_flower

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inset (biarkan seperti punyamu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // === INISIALISASI ===
        val etAlas = findViewById<EditText>(R.id.etAlas)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val etSisi = findViewById<EditText>(R.id.etSisi)
        val btnSegitiga = findViewById<Button>(R.id.btnSegitiga)
        val btnKubus = findViewById<Button>(R.id.btnKubus)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // === LUAS SEGITIGA ===
        btnSegitiga.setOnClickListener {
            val alas = etAlas.text.toString().toDoubleOrNull()
            val tinggi = etTinggi.text.toString().toDoubleOrNull()

            if (alas != null && tinggi != null) {
                val hasil = 0.5 * alas * tinggi
                tvHasil.text = "Luas Segitiga = $hasil"
            } else {
                Toast.makeText(this, "Masukkan alas & tinggi!", Toast.LENGTH_SHORT).show()
            }
        }

        // === VOLUME KUBUS ===
        btnKubus.setOnClickListener {
            val sisi = etSisi.text.toString().toDoubleOrNull()

            if (sisi != null) {
                val hasil = sisi * sisi * sisi
                tvHasil.text = "Volume Kubus = $hasil"
            } else {
                Toast.makeText(this, "Masukkan sisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}