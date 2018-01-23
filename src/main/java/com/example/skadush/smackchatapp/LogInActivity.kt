package com.example.skadush.smackchatapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
    }

    fun logInButtonClick(view: View){

    }

    fun loginCreateUserButtonClick(view:View){
        val createIntent = Intent(this,CreateUserActivity::class.java)
        startActivity(createIntent)
    }
}
