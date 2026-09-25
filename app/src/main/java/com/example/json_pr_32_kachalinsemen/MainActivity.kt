package com.example.json_pr_32_kachalinsemen

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etPrice: EditText
    private lateinit var etTags: EditText
    private lateinit var btnSerialize: AppCompatButton
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val book = Product(
            name = "Программирование на Kotlin",
            price = 1500.0,
            tags = listOf("учебник", "программирование", "android")
        )
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPrice = findViewById(R.id.etPrice)
        etTags = findViewById(R.id.etTags)
        btnSerialize = findViewById(R.id.btnSerialize)
        tvResult = findViewById(R.id.tvResult)

        btnSerialize.setOnClickListener {

            val name = etName.text.toString().trim()
            val price = etPrice.text.toString().toDouble()
            val tags = etTags.text.toString()
                .split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            val userProduct = Product(name, price, tags)
            val jsonString = Gson().toJson(userProduct)
            tvResult.text = jsonString;
            val NoJsonString = Gson().fromJson(jsonString,Product::class.java)
            Log.d("MyApp","name: ${NoJsonString.name} price: ${NoJsonString.price} tags: ${NoJsonString.tags}");
        }
    }
}
