package com.kartik.grevocab.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import com.optus.Group
import com.optus.R

import java.util.ArrayList

class GroupsRecyclerAdapter(internal var groupItems: ArrayList<Group>) : RecyclerView.Adapter<GroupsRecyclerAdapter.ViewHolder>() {
    //Cursor data;
    internal var clickListener: OnItemClickListener? = null

    override fun getItemCount(): Int {

        return groupItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val t = groupItems[position]
        holder.name.text = t.name


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.inflate_groups, parent, false)
        return ViewHolder(v)
    }


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickLickListener(listener: OnItemClickListener) {

        clickListener = listener
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener {

        internal var name: TextView

        init {
            name = itemView.findViewById(R.id.GroupName)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {

            clickListener?.onItemClick(v, this.adapterPosition) //OnItemClickListener mItemClickListener;
        }

    }

}
