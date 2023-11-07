package com.example.tugaspertemuan10_recyclerview

// Mendefinisikan data class Student, yang digunakan untuk merepresentasikan data mahasiswa
data class Student(
    val name: String = "",     // Nama mahasiswa, defaultnya kosong
    val ipk: String = "",      // Indeks Prestasi Kumulatif (IPK) mahasiswa, defaultnya kosong
    val imageResId: Int       // ID sumber daya gambar yang merepresentasikan gambar mahasiswa
)