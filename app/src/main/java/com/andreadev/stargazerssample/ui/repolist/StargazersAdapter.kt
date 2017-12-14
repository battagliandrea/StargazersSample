package com.andreadev.stargazerssample.ui.repolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.R.id.tv
import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.ui.extensions.ctx
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.view_stargazers_item.view.*

/**
 * Created by andrea on 14/09/2017.
 */
class StargazersAdapter(val context: Context, val listener: StargazersAdapterListener) : RecyclerView.Adapter<StargazersAdapter.ViewHolder>(){

    private var items: List<Stargazer>
    private val mListener : StargazersAdapterListener = listener

    init {
        items = ArrayList()
    }

    interface StargazersAdapterListener {
        fun onBottomReached(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder = ViewHolder(LayoutInflater.from(parent.ctx).inflate(R.layout.view_stargazers_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))

        if (position == items.size - 1){
            listener.onBottomReached(position)
        }
    }

    override fun getItemCount() = items.size

    fun setData(items: List<Stargazer>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Stargazer) {
            view.tv.text = item.login

            Glide.with(context).load(item.avatar_url).apply(RequestOptions.circleCropTransform()).into(view.iv)
        }
    }
}