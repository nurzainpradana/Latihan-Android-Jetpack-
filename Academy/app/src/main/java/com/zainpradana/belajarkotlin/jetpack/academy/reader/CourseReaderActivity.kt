package com.zainpradana.belajarkotlin.jetpack.academy.reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zainpradana.belajarkotlin.jetpack.academy.R

class CourseReaderActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)
    }
}