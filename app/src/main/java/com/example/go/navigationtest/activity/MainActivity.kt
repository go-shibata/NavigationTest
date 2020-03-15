package com.example.go.navigationtest.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.go.navigationtest.R
import com.example.go.navigationtest.fragment.QuizListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, QuizListFragment.newInstance())
            .commit()
    }
}
