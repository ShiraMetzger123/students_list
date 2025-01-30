package com.example.students

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students.databinding.ActivityStudentDetailsBinding

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Student Details"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        student = intent.getParcelableExtra("student")

        // Populate student details
        updateStudentDetails()

        // Edit button
        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student", student)
            startActivityForResult(intent, EDIT_STUDENT_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_STUDENT_REQUEST_CODE && resultCode == RESULT_OK) {
            student = data?.getParcelableExtra("updatedStudent")
            updateStudentDetails()
        }
    }

    private fun updateStudentDetails() {
        student?.let {
            binding.tvName.text = "Name: ${it.name}"
            binding.tvId.text = "ID: ${it.id}"
            binding.tvPhone.text = "Phone: ${it.phone}"
            binding.tvAddress.text = "Address: ${it.address}"
            binding.cbChecked.isChecked = it.checked
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EDIT_STUDENT_REQUEST_CODE = 1001
    }
}
