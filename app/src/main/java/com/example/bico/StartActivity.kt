package com.example.bico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bico.databinding.ActivityMainBinding
import com.example.bico.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_start)
        var binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.course.setOnClickListener{
            var intent = Intent(this, CourseActivity::class.java)
            startActivity(intent)
        }


        binding.MyBico.setOnClickListener{
            var intent = Intent(this, MyBicoActivity::class.java)
            startActivity(intent)
        }
        binding.diary.setOnClickListener{
            var intent = Intent(this, DiaryActivity::class.java)
            startActivity(intent)
        }
    }
}