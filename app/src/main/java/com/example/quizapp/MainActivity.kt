package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart: Button = findViewById(R.id.btn_start)
        val etname: EditText = findViewById(R.id.et_name)
        val topic: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        // Create an ArrayAdapter with the data for autocomplete suggestions
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            resources.getStringArray(R.array.items)
        )
        topic.setAdapter(adapter)

        btnstart.setOnClickListener {
            if (etname.text.isEmpty()) {
                Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show()
            }
            else if (topic.text.isEmpty()) {
                Toast.makeText(this, "Please select the topic", Toast.LENGTH_LONG).show()
            }
            else {
                val selectedTopic = topic.text.toString()

                val intent = Intent(this, QuizQuestions::class.java)
                intent.putExtra(Constant.USER_NAME, etname.text.toString())
                intent.putExtra(Constant.SELECTED_TOPIC, selectedTopic)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}