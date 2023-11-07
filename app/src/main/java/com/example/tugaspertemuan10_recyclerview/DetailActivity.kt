package com.example.tugaspertemuan10_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaspertemuan10_recyclerview.databinding.ActivityDetailBinding

// Mendefinisikan kelas DetailActivity yang merupakan turunan dari AppCompatActivity
class DetailActivity : AppCompatActivity() {
    // Mendeklarasikan variabel untuk binding tampilan menggunakan View Binding
    private lateinit var binding : ActivityDetailBinding

    // Metode onCreate() dipanggil saat aktivitas ini dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menginisialisasi binding dengan mengambil layout tampilan menggunakan inflate
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data yang dikirimkan dari aktivitas sebelumnya melalui intent
        val studentName = intent.getStringExtra("name")
        val studentIpk = intent.getStringExtra("ipk")
        val studentImage = intent.getIntExtra("image", 0)

        // Menggunakan View Binding untuk menetapkan data ke elemen-elemen tampilan
        binding.apply {
            nameTxt.text = studentName  // Menetapkan nama mahasiswa ke TextView dengan id nameTxt
            ipkTxt.text = studentIpk    // Menetapkan IPK mahasiswa ke TextView dengan id ipkTxt
            imgIcon.setImageResource(studentImage)  // Menetapkan gambar mahasiswa ke ImageView dengan id imgIcon
        }
    }
}