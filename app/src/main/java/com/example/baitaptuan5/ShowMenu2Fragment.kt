package com.example.baitaptuan5

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baitaptuan5.databinding.*

class ShowMenu2Fragment : Fragment() {

    lateinit var viewMode:MainVM
    lateinit var adapter: RestaurantAdapter

    lateinit var binding : FragmentShowmenu2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_show_menu)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowmenu2Binding.inflate(inflater, container, false)
        viewMode = ViewModelProvider(this).get(MainVM::class.java)


        adapter = RestaurantAdapter()
        val lm = LinearLayoutManager(this.context)

        binding.rvRestaurant.layoutManager = lm
        binding.rvRestaurant.adapter = adapter
        registerData()
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

    override fun onStart() {
        super.onStart()
        viewMode.loadData()
    }
    private fun registerData(){
        viewMode.listOfData.observe(this){
            adapter.submitList(it)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button3.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_showMenu2Fragment_to_profileFragment)
        }
    }

}