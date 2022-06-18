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
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

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
        binding.kakaologin.setOnClickListener{
            // 토큰 정보 보기
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    Log.e("mobileApp", "토큰 정보 보기 실패", error)
                }
                else if (tokenInfo != null) {
                    Log.i("mobileApp", "토큰 정보 보기 성공")
                    finish()
                }
            }
            // 로그인 조합 예제

            // 카카오계정으로 로그인 공통 callback 구성
            // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e("mobileApp", "카카오계정으로 로그인 실패", error)
                } else if (token != null) {
                    Log.i("mobileApp", "카카오계정으로 로그인 성공 ${token.accessToken}")
                }
            }
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)}
            else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                }
            }
        }



    }
//    override fun onStart() {
//        super.onStart()
//        if(loginApplication.checkAuth()){
//
//        }
//    }
