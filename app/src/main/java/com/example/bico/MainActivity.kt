package com.example.bico

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
//import com.kakao.sdk.common.util.Utility
import com.example.bico.databinding.ActivityMainBinding
//import net.daum.mf.map.api.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val keyHash = Utility.getKeyHash(this)
//        Log.d("mobileApp", keyHash)

        binding.login.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            intent.putExtra("data","login")
            startActivity(intent)
        }

        binding.signup.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            intent.putExtra("data","signup")
            startActivity(intent)
        }

        binding.test.setOnClickListener{
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }



    }
//    override fun onStart() {
//        super.onStart()
//        if(loginApplication.checkAuth()){
//
//        }
//    }
}