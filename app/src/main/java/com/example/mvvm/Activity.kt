package com.example.mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.Blog
import com.example.mvvm.view.NoteRecyclerAdapter
import com.example.mvvm.viewModel.MainViewModel
import com.example.mvvm.viewModel.MainViewModelFactory
import com.example.mykotlinapp.R

class MainActivity : AppCompatActivity() {
    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var mainrecycler: RecyclerView
    private lateinit var but: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avtiv)
        mainrecycler = findViewById(R.id.recycler)
        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()
        viewModel = ViewModelProviders.(this,factory).get(MainViewModel::class.java)
        but = findViewById(R.id.button)
        but.setOnClickListener {
            addData()
        }

        initialiseAdapter()
    }
    private fun initialiseAdapter(){
        mainrecycler.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        viewModel.lst.observe(this, Observer{
            Log.i("data",it.toString())
            mainrecycler.adapter= NoteRecyclerAdapter(viewModel, it, this)
        })
    }


    fun addData(){
        var txtplce = findViewById<EditText>(R.id.titletxt)
        var title=txtplce.text.toString()
        if(title.isNullOrBlank()){
            Toast.makeText(this,"Enter value!", Toast.LENGTH_LONG).show()
        }else{
            var blog= Blog(title)
            viewModel.add(blog)
            txtplce.text.clear()
            mainrecycler.adapter?.notifyDataSetChanged()
        }

    }
}