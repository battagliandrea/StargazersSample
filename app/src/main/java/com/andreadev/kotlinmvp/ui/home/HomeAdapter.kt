package com.andreadev.kotlinmvp.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreadev.kotlinmvp.R
import com.andreadev.kotlinmvp.ui.extensions.ctx
import kotlinx.android.synthetic.main.list_item_home.view.*

/**
 * Created by andrea on 14/09/2017.
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    private var items: List<String>
    //private val listener: (String) -> Unit

    init {
        items = ArrayList<String>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder = ViewHolder(LayoutInflater.from(parent.ctx).inflate(R.layout.list_item_home, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    fun setData(items: List<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) = with(itemView) {
            tv.text = item
        }
    }
}