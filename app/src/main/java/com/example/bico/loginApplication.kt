package com.example.bico

import androidx.multidex.MultiDexApplication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class loginApplication: MultiDexApplication() {
    companion object{
        lateinit var auth: FirebaseAuth
        var email:String?=null

        fun checkAuth():Boolean{
            var currentUser = auth.currentUser
            return currentUser?.let {
                email = currentUser.email
                currentUser.isEmailVerified
            }?:let{
                false
            }
            }

        }
    override fun onCreate() {
        super.onCreate()
        auth = Firebase.auth
    }
    }

