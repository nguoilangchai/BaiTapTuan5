package com.example.baitaptuan5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.baitaptuan5.databinding.FragmentSignup2Binding


class SignUp2Fragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    lateinit var binding : FragmentSignup2Binding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        binding.btnSignUp2.setOnClickListener {
//            val email = binding.txtEmail.text.toString().trim()
//            val passWord = binding.txtPassWord.text.toString().trim()
//
//            viewModel.checkEmailAndPassword(email, passWord)
//            listenerSuccessEvent()
//            listenerErrorEvent()
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignup2Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnSignUp2.setOnClickListener {
            val email = binding.txtEmail.text.toString().trim()
            val passWord = binding.txtPassWord.text.toString().trim()

            viewModel.checkEmailAndPassword(email, passWord)
            listenerSuccessEvent()
            listenerErrorEvent()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignUp2.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_signUp2Fragment_to_login2Fragment)
        }
    }

    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){
            if(it){
                val email = binding.txtEmail.text.toString().trim()
                val passWord = binding.txtPassWord.text.toString().trim()
                //val intent = Intent(this, Login::class.java)
                val controller = findNavController()
                controller.navigate(R.id.action_signUp2Fragment_to_login2Fragment)

                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, DataStore(email, passWord))
                //intent.putExtras(bundle)
                //Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
                showToastMessage("Đăng ký thành công")
                //startActivity(intent)
            }
        }
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){errMsg ->
//            val dialog = AlertDialog.Builder(this)
//            dialog.setTitle("Error")
//            dialog.setMessage(errMsg)
//            dialog.show()
            //Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
            showToastMessage("Đăng ký thất bại")
        }
    }

}