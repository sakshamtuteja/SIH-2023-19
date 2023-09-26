package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Sign_In : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView.setOnClickListener {
            val intent = Intent(this, Sign_up::class.java)
            startActivity(intent)}
            binding.Button.setOnClickListener {

                val emaili = binding.email.text.toString()
                val pass = binding.password.text.toString()
                if (emaili.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(emaili,pass).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this, "hiiiiii", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@Sign_In, Home::class.java)
                            startActivity(intent)
                        }

                      else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

                }
                //binding.progressBar2.visibility = View.GONE
            }
        }
        /*           override fun onStart(){
               super.onStart()
               if(firebaseAuth.currentUser != null){
                   val intent = Intent(this, MainActivity::class.java)
                   startActivity(intent)
               }

           }*/
    }