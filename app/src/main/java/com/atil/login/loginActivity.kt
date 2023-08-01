package com.atil.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.atil.login.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.loginbutton.setOnClickListener {
            val loginUsername =binding.logineditText.text.toString()
            val loginPassword =binding.logineditText2.text.toString()
            loginDatebase(loginUsername,loginPassword)
        }
        binding.signupRedirect.setOnClickListener {
            Toast.makeText(this, "Login Succefful", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,signupActivity ::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun loginDatebase(username:String,password:String){
        val userExists= databaseHelper.readUser(username,password)
        if (userExists){
            Toast.makeText(this, "Login Succefful", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,MainActivity ::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}