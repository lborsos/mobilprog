package com.borsos.laszlo.finalprojectapplication

import MyAdapter
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView2 = findViewById<TextView>(R.id.textView2)
//        val textView3 = findViewById<TextView>(R.id.textView3)
        val editText4 = findViewById<TextView>(R.id.editText4)
        val receivedText1 = intent.getStringExtra("EDIT_TEXT_1")
        val receivedText2 = intent.getStringExtra("EDIT_TEXT_2")

        textView2.text = receivedText1 ?: "No data received"
//        textView3.text = receivedText2 ?: "No data received"
        editText4.text = receivedText2 ?: "No data received"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val button3 = findViewById<Button>(R.id.button3)

        val verses_sorok = arrayOf(
            "Oh, the weather outside is frightful",
            "But the fire is so delightful",
            "And since we've no place to go",
            "Let It Snow! Let It Snow! Let It Snow!",
            "Man it doesn't show signs of stopping",
            "And I brought me some corn for popping",
            "The lights are turned way down low",
            "Let It Snow! Let It Snow!",
            "When we finally kiss goodnight",
            "How I'll hate going out in the storm",
            "But if you'll really hold me tight",
            "All the way home I'll be warm",
            "And the fire is slowly dying",
            "And, my dear, we're still goodbying",
            "But as long as you'd love me so",
            "Let It Snow! Let It Snow and snow!"
        ).toMutableList()

        val adapter = MyAdapter(verses_sorok)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        editText4.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                val newText = editText4.text.toString().trim()
                if (newText.isNotEmpty()) {
                    verses_sorok.add(newText)
                    adapter.notifyItemInserted(verses_sorok.size - 1)
                    recyclerView.scrollToPosition(verses_sorok.size - 1)
                    editText4.text = ""
                }
                true
            } else {
                false
            }
        }
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = MyAdapter(verses_sorok.toList())

        button3.setOnClickListener {
            val intent = Intent(this, SensorActivity::class.java)
            startActivity(intent)
        }
    }
}