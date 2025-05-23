package com.borsos.laszlo.f4mqfm_mp2_1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observer = MyLifecycleObserver()
        lifecycle.addObserver(observer)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val input = editText.text.toString()
            textView.text = input

//            Handler(Looper.getMainLooper()).postDelayed({
//                textView.text = "Háttérfolyamat után frissítve"
//            }, 3000)
            lifecycleScope.launch {
                delay(3000)
                textView.text = "Háttérfolyamat után frissítve"
            }
        }
        Toast.makeText(this, "App elindult!", Toast.LENGTH_LONG).show()
    }
}
