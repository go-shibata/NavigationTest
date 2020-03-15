package com.example.go.navigationtest.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.go.navigationtest.databinding.FragmentQuizListItemBinding
import com.example.go.navigationtest.model.Quiz
import kotlinx.android.synthetic.main.fragment_quiz_list_item.view.*

class MyQuizRecyclerViewAdapter(
    private val mValues: List<Quiz>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyQuizRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Quiz
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentQuizListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mBinding.quiz = item

        holder.mBinding.root.apply {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size


    inner class ViewHolder(val mBinding: FragmentQuizListItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        override fun toString(): String {
            return "${super.toString()} '${mBinding.root.content.text}'"
        }
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Quiz?)
    }
}
