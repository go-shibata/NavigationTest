package com.example.go.navigationtest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.go.navigationtest.databinding.FragmentQuizDetailBinding
import com.example.go.navigationtest.model.Quiz
import com.example.go.navigationtest.view.adapter.QuizDetailRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_quiz_detail.view.*

class QuizDetailFragment : Fragment(), QuizDetailRecyclerViewAdapter.OnClickChoiceListener {
    private lateinit var mQuiz: Quiz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mQuiz = it.getSerializable(ARG_QUIZ) as Quiz
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuizDetailBinding.inflate(inflater, container, false)

        binding.root.list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = QuizDetailRecyclerViewAdapter(
                mQuiz,
                this@QuizDetailFragment
            )
        }

        return binding.root
    }

    companion object {
        private const val ARG_QUIZ = "arg_quiz"

        @JvmStatic
        fun newInstance(quiz: Quiz) =
            QuizDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_QUIZ, quiz)
                }
            }
    }

    override fun onClickChoice(item: Int) {
        TODO("Not yet implemented")
    }
}
