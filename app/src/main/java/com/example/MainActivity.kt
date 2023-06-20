package com.example

import UserAdapter1
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.viewModel.UserViewModel
import com.example.mvvm_api_request.model.PokemonAPIServiceMVVM
import com.example.mvvm_api_request.model.PokemonMVVM
import com.example.mvvm_api_request.view.PokemonMVVM_adapter
import com.example.mvvm_api_request.viewModel.PokemonMVVM_View_Model
import com.example.mykotlinapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    //  var mTextViewResult: RecyclerView? = null
    private lateinit var binding: ActivityMainBinding
//    var pokAPI = PokemonAPIService()
    //        val adapter1 = PokemonAdapter()
private var pokAPIMvvM: PokemonAPIServiceMVVM?=null

    private var userVM: UserViewModel? = null
    private var pokVM: PokemonMVVM_View_Model = PokemonMVVM_View_Model()
    private val adapter1 = UserAdapter1()
    private val adapterPok = PokemonMVVM_adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        userVM = ViewModelProvider(this)[UserViewModel::class.java]
        pokVM = ViewModelProvider(this)[PokemonMVVM_View_Model::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapterPok

//        binding.updateBtn.setOnClickListener {
//            Log.d(tAG, "abababaaaaaaaaaa")
//            pokVM?.updateListPokemons()
//        }

        pokVM?.pokemon_mvvm_List?.observe(this, Observer {
            it?.let {
                adapterPok.refreshPoks(it)
            }
        }
            )



//        GlobalScope.launch(Dispatchers.IO) {
//            pokAPIMvvM!!.requestPokApi(
//                onResponse = {
//                    runOnUiThread {
//                        adapterPok.pokemonMVVMs = it
//                        adapterPok.notifyDataSetChanged()
//                    }
//
//                }
//            )
//        }
        Log.d(tAG, "Activity created")
    }

    private var tAG = "lifecycle"


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = UserAdapter().apply {
//            data = listOf(
//                Users("name1"),
//                Users("name2"),
//                Users("name3"),
//                Users("name4"),
//                Users("name5"),
//                Users("name6"),
//                Users("name7"),
//                Users("name8"),
//                Users("name9"),
//            )
//            notifyDataSetChanged()
//        }

//        binding.recyclerView.adapter = adapter
//        Log.d(tAG, "Activity created")
//    }
}