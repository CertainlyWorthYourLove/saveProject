package com.example.homework6

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val fName = sharedPreferences.getString("firstName", "")
        val lName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getInt("age", 0)
        val address = sharedPreferences.getString("address", "")

        emailEditText.setText(email)
        firstNameEditText.setText(fName)
        lastNameEditText.setText(lName)
        ageEditText.setText(age.toString())
        addressEditText.setText(address)
    }
    

    fun save(view: View){
        if(emailEditText.text.toString().isNotEmpty() && firstNameEditText.text.toString().isNotEmpty() && lastNameEditText.text.toString().isNotEmpty() && addressEditText.text.toString().isNotEmpty() && ageEditText.text.toString().isNotEmpty()) {
            val edit = sharedPreferences.edit()
            val email = emailEditText.text.toString()
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val age = ageEditText.text.toString().toInt()
            val address = addressEditText.text.toString()
            edit.putString("email", email)
            edit.putString("firstName", firstName)
            edit.putString("lastName", lastName)
            edit.putInt("age", age)
            edit.putString("address", address)
            edit.apply()
            Toast.makeText(this, "Saved successfully", Toast.LENGTH_LONG).show()
            emailEditText.text.clear()
            firstNameEditText.text.clear()
            lastNameEditText.text.clear()
            ageEditText.text.clear()
            addressEditText.text.clear()

        }
        else{
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
        }

    }

}