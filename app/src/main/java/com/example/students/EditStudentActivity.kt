package com.example.students

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students.databinding.ActivityEditStudentBinding

class EditStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStudentBinding
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Edit Student"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        student = intent.getParcelableExtra("student")

        student?.let {
            binding.etName.setText(it.name)
            binding.etId.setText(it.id)
            binding.etPhone.setText(it.phone)
            binding.etAddress.setText(it.address)
            binding.cbChecked.isChecked = it.checked
        }

        binding.btnSave.setOnClickListener {
            student?.let {

                it.name = binding.etName.text.toString()
                it.id = binding.etId.text.toString()
                it.phone = binding.etPhone.text.toString()
                it.address = binding.etAddress.text.toString()
                it.checked = binding.cbChecked.isChecked


                StudentRepository.updateStudent(it)


                val intent = Intent()
                intent.putExtra("updatedStudent", it)
                setResult(RESULT_OK, intent)
                finish()
            }
        }


        binding.btnDelete.setOnClickListener {
            student?.let {
                StudentRepository.deleteStudent(it)


                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
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