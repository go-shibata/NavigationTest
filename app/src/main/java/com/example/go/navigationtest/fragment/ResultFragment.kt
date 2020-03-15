package com.example.go.navigationtest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.go.navigationtest.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var isCorrect: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isCorrect = ResultFragmentArgs.fromBundle(it).isCorrect
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.isCorrect = isCorrect
        return binding.root
    }
}
