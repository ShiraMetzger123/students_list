package com.example.students

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    var name: String,
    var id: String,
    var phone: String,
    var address: String,
    var checked: Boolean
) : Parcelable
