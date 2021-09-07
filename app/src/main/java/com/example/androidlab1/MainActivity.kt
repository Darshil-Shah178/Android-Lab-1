package com.example.androidlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)


        findViewById<Button>(R.id.clickBtn).setOnClickListener {

            val username = findViewById<EditText>(R.id.userName)
            val personName: String? = username.text.toString()

            welcomeText.text = if (username.text.isEmpty()) {
                when (welcomeText.text) {
                    getText(R.string.introtext) -> getText(R.string.goodbye)
                    getText(R.string.goodbye) -> getText(R.string.introtext)
                    else -> getText(R.string.introtext)
                }
            }
            else{
                getString(R.string.hello_name, personName)
            }
            username.text.clear()
        }
    }
}