package com.example.androidversions.ui.mainactivity2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidversions.R
import com.example.androidversions.model.Versions
import com.example.androidversions.ui.mainactivity.MainActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data = intent.getParcelableExtra<Versions>(MainActivity.intentKey)
        val scntv = findViewById<TextView>(R.id.scn_tv)
        data?.let {
            scntv.text = "${it.versionName}, API LEVEL ${it.apiLevel}"
    }
    }


    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity2::class.java)
        }

    }
}