package com.example.students

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(student: Student) {
        val index = students.indexOfFirst { it.id == student.id }
        if (index != -1) {
            students[index] = student
        }
    }

    fun deleteStudent(student: Student) {
        students.removeIf { it.id == student.id }
    }

    fun getStudents(): List<Student> {
        return students
    }
}
