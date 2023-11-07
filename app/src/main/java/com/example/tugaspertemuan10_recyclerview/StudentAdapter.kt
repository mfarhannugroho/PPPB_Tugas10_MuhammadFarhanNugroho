package com.example.tugaspertemuan10_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan10_recyclerview.databinding.ItemStudentBinding

// Mendefinisikan tipe alias OnClickStudent, yang merupakan tipe fungsi dengan parameter Student
typealias OnClickStudent = (Student) -> Unit

// Kelas StudentAdapter digunakan untuk mengatur tampilan daftar mahasiswa di RecyclerView
class StudentAdapter(private val listStudents: List<Student>,
                     private val onClickStudent: OnClickStudent) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // Kelas inner StudentViewHolder digunakan untuk mengelola tampilan setiap item dalam RecyclerView
    inner class StudentViewHolder(private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {
        // Fungsi bind digunakan untuk mengisi data mahasiswa ke tampilan item
        fun bind(student: Student) {
            with(binding) {
                ipkTxt.text = student.ipk
                nameTxt.text = student.name
                imgIcon.setImageResource(student.imageResId)

                // Menambahkan tindakan saat item diklik
                itemView.setOnClickListener {
                    onClickStudent(student)
                }
            }
        }
    }

    // Metode onCreateViewHolder digunakan untuk membuat instance ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StudentViewHolder(binding)
    }

    // Metode getItemCount mengembalikan jumlah item dalam daftar mahasiswa
    override fun getItemCount(): Int {
        return listStudents.size
    }

    // Metode onBindViewHolder digunakan untuk mengisi data ke ViewHolder
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = listStudents[position]
        holder.bind(student)

        val ipkTextView = student.ipk
        val ipk = student.ipk.toDoubleOrNull()

        // Mengatur warna latar belakang item berdasarkan IPK mahasiswa
        if (ipk != null) {
            when {
                ipk >= 3.5 -> {
                    holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.gray1))
                }
                ipk >= 3.0 -> {
                    holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.gray2))
                }
                else -> {
                    holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.gray3))
                }
            }
        }
    }
}
