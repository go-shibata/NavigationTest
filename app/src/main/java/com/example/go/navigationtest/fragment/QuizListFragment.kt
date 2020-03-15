package com.example.go.navigationtest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.go.navigationtest.databinding.FragmentQuizListBinding
import com.example.go.navigationtest.model.Quiz
import com.example.go.navigationtest.view.adapter.MyQuizRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_quiz_list.view.*

class QuizListFragment : Fragment(), MyQuizRecyclerViewAdapter.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuizListBinding.inflate(inflater, container, false)

        binding.root.list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MyQuizRecyclerViewAdapter(
                Quiz.sDummyData,
                this@QuizListFragment
            )
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = QuizListFragment()
    }

    override fun onListFragmentInteraction(item: Quiz) {
        println(item)
        view?.findNavController()?.navigate(
            QuizListFragmentDirections.actionQuizListFragmentToQuizDetailFragment(item)
        )
    }
}
