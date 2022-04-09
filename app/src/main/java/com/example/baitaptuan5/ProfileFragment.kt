package com.example.baitaptuan5

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baitaptuan5.databinding.FragmentOnboardingBinding
import com.example.baitaptuan5.databinding.FragmentProfileBinding
import com.example.baitaptuan5.databinding.FragmentSplashBinding
import com.example.baitaptuan5.databinding.FragmentWelcomeBinding

class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDetailProfile.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_profileFragment_to_welcomeFragment)
        }
    }

}