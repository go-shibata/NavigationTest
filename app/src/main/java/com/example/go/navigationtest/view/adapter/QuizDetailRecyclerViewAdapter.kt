package com.example.go.navigationtest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.go.navigationtest.databinding.FragmentQuizDetailItemBinding
import com.example.go.navigationtest.model.Quiz
import kotlinx.android.synthetic.main.fragment_quiz_detail_item.view.*

class QuizDetailRecyclerViewAdapter(
    private val mQuiz: Quiz,
    private val mListener: OnClickChoiceListener?
) : RecyclerView.Adapter<QuizDetailRecyclerViewAdapter.ViewHolder>() {
    private val mOnCLickListener: View.OnClickListener

    init {
        mOnCLickListener = View.OnClickListener { v ->
            val index = v.tag as Int
            mListener?.onClickChoice(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentQuizDetailItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mQuiz.mChoices[position]
        holder.mBinding.choice = item

        holder.mBinding.root.apply {
            tag = position
            setOnClickListener(mOnCLickListener)
        }
    }

    override fun getItemCount(): Int = mQuiz.mChoices.size

    inner class ViewHolder(val mBinding: FragmentQuizDetailItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        override fun toString(): String {
            return "${super.toString()} '${mBinding.root.content.text}'"
        }
    }

    interface OnClickChoiceListener {
        fun onClickChoice(item: Int)
    }
}