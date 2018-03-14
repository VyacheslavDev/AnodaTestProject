package com.safviach.anodatestproject.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.safviach.anodatestproject.R
import com.safviach.anodatestproject.model.Feed
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedHolder>() {
    private val mFeeds: ArrayList<Feed> = arrayListOf()

    fun addItems(feeds: List<Feed>) { //add to an existing array, without .clear
        mFeeds.addAll(feeds)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return FeedHolder(layoutInflater.inflate(R.layout.item_feed, parent, false))
    }

    override fun getItemCount(): Int {
        return mFeeds.size
    }

    override fun onBindViewHolder(holder: FeedHolder?, position: Int) {
        val feed = mFeeds[position]
        holder?.bind(feed)
    }

    class FeedHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(feed: Feed){
            itemView.tv_title.text = feed.title
            itemView.iv_photo.setImageDrawable(feed.image)
        }
    }

}
