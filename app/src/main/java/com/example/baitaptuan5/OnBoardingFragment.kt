package com.example.baitaptuan5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.baitaptuan5.databinding.FragmentOnboardingBinding
import com.example.baitaptuan5.databinding.FragmentSplashBinding

class OnBoardingFragment : Fragment() {

    lateinit var binding : FragmentOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_onBoardingFragment_to_welcomeFragment)
        }
    }


}