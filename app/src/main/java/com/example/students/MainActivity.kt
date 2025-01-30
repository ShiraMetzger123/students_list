package com.example.students

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.students.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = "Students List"


        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.fabAddStudent.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()


        val studentList = StudentRepository.getStudents()
        val adapter = StudentAdapter(studentList) { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student", student)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
    }
}