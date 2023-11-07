package com.example.tugaspertemuan10_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Membuat adapter untuk RecyclerView dan mengisinya dengan data mahasiswa
        val adapterStudent = StudentAdapter(generateStudentData()) { student ->
            // Menampilkan pesan toast yang berisi nama mahasiswa yang dipilih
            Toast.makeText(this@MainActivity, " ${student.name}", Toast.LENGTH_SHORT).show()

            // Membuat intent untuk memulai aktivitas DetailActivity dan mengirim data mahasiswa
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("name", student.name)
            intent.putExtra("ipk", student.ipk)
            intent.putExtra("image", student.imageResId)
            startActivity(intent)
        }

        // Menghubungkan RecyclerView dengan adapter dan mengatur tata letak
        with(binding) {
            rvStudent.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    // Fungsi untuk menghasilkan data mahasiswa dalam bentuk daftar
    private fun generateStudentData(): List<Student> {
        return listOf(
            Student("Marcus Rashford", "3.8", R.drawable.photo_1),
            Student("Jude Bellingham", "3.6", R.drawable.photo_2),
            Student("Romelu Lukaku", "3.5", R.drawable.photo_3),
            Student("Frankie De Jong", "3.4", R.drawable.photo_4),
            Student("Erling Haaland", "3.2", R.drawable.photo_5),
            Student("Luka Modric", "3.1", R.drawable.photo_1),
            Student("Taufik Hidayat", "2.9", R.drawable.photo_2),
            Student("John Cena", "2.7", R.drawable.photo_3),
            Student("Lim Swie King", "2.5", R.drawable.photo_4),
            Student("Rey Mysterio", "2.2", R.drawable.photo_5)
        )
    }
}
