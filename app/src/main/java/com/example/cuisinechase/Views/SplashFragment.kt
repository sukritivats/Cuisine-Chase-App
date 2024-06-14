package com.example.cuisinechase.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.cuisinechase.R
import com.example.cuisinechase.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideViews()
        init()
    }

    private fun init() {
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }
    private fun hideViews() {
        val bottomNav = activity?.findViewById<View>(R.id.btmNav)
        bottomNav?.visibility = View.GONE

    }
    private fun showViews() {
        val bottomNav = activity?.findViewById<View>(R.id.btmNav)
        bottomNav?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showViews()
        _binding = null
    }

}