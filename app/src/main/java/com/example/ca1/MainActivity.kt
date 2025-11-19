package com.example.ca1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar = findViewById<Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolbar)


        lateinit var button: Button
        lateinit var returnDays: EditText

        button = findViewById(R.id.button2)
        button.setOnClickListener {
            returnDays = findViewById(R.id.inputField)
            var days = returnDays.text
            if (days.isEmpty()){
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_LONG).show()
            }
            else if (days.toString().toInt() > 10){
                Toast.makeText(this, "You will have to pay for this delay", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "You are free to go man", Toast.LENGTH_LONG).show()
            }
        }
    }
}