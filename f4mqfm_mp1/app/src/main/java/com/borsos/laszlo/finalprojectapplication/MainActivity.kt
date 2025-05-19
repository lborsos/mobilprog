package com.borsos.laszlo.finalprojectapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)

        button1.setOnClickListener {
            textView1.text = button1.text
            val phoneNumber = "tel:112233445566"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse(phoneNumber)
            }
            startActivity(intent)
        }
        button2.setOnClickListener {
            textView1.text = button2.text
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EDIT_TEXT_1", editText1.text.toString())
            intent.putExtra("EDIT_TEXT_2", editText2.text.toString())

            startActivity(intent)
        }
    }
}