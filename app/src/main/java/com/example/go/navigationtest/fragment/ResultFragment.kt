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
            isCorrect = it.getBoolean(ARG_IS_CORRECT)
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

    companion object {
        private const val ARG_IS_CORRECT = "arg_is_correct"

        @JvmStatic
        fun newInstance(isCorrect: Boolean) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_IS_CORRECT, isCorrect)
                }
            }
    }
}
