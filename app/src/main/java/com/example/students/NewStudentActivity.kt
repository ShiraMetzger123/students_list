package com.example.students

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students.databinding.ActivityNewStudentBinding

class NewStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = "New Student"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val id = binding.etId.text.toString()
            val phone = binding.etPhone.text.toString()
            val address = binding.etAddress.text.toString()
            val checked = binding.cbChecked.isChecked

            val newStudent = Student(name, id, phone, address, checked)
            StudentRepository.addStudent(newStudent)

            setResult(RESULT_OK)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}