package com.example.bico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bico.databinding.ActivityCourseBinding
import com.example.bico.databinding.ActivityStartBinding

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_course)
        var binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Realfragment = realFragment()
        val bundle = Bundle()
            bundle.putString("returnType", "json")
            Realfragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_content, Realfragment)
                .commit()
    }
}