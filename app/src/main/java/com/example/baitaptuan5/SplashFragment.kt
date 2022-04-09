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
import com.example.baitaptuan5.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        val handler = Handler(Looper.getMainLooper())
        val runnable:Runnable = object:Runnable {
            override fun run() {
                controller.navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }
        }
        handler.postDelayed(runnable,4000)
    }

}