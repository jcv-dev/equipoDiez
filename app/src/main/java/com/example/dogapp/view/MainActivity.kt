package com.example.dogapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }
}