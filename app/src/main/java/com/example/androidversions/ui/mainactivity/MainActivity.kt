package com.example.androidversions.ui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidversions.ui.mainactivity2.MainActivity2
import com.example.androidversions.model.Models
import com.example.androidversions.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainRv: RecyclerView

    companion object{
        const val intentKey = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter =
            MainAdapter(Models.versions) {
                val i =
                    MainActivity2.getIntent(
                        this
                    )
                i.putExtra(
                    intentKey,
                    it
                )
                startActivity(i)
            }
        adapter.setOnClick(object:
            SetOnClick {
            override fun itemClick(message: String) {
                val i =
                    MainActivity2.getIntent(
                        this@MainActivity
                    )
                i.putExtra(intentKey,message)
                startActivity(i)
            }

        })
        mainRv = findViewById(R.id.main_rv)
        mainRv.apply{
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }

    }

    interface SetOnClick{
        fun itemClick(message: String)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_linear -> mainRv.layoutManager = LinearLayoutManager(this)
            R.id.menu_grid -> mainRv.layoutManager = GridLayoutManager(this, 2)
            else -> {
                mainRv.layoutManager = LinearLayoutManager(this)
            }
        }
        return true
    }
}