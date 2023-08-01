package com.atil.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.atil.login.databinding.ActivitySignupBinding

class signupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(context = this)

        binding.signupbutton.setOnClickListener {
            val signupUsername = binding.signupeditText.text.toString()
            val signupPassword = binding.signupeditText2.text.toString()
            signupDatebase(signupUsername,signupPassword)
        }

       binding.loginRedirect.setOnClickListener {
           val intent = Intent(this,loginActivity :: class.java)
           startActivity(intent)
           finish()

       }


    }
    private fun signupDatebase(username:String,password:String){
        val insretRowId = databaseHelper.insertUser(username,password)
        if (insretRowId != -1L){
            Toast.makeText(this, "Signup Successuful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,loginActivity :: class.java)
          startActivity(intent)
            finish()
        }else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }
}