package com.safviach.anodatestproject.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import com.safviach.anodatestproject.R
import com.safviach.anodatestproject.model.Feed
import com.safviach.anodatestproject.ui.adapter.FeedAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(this)
        rv_feed.layoutManager = linearLayoutManager

        val feedAdapter = FeedAdapter()
        rv_feed.adapter = feedAdapter
        feedAdapter.addItems(getTestFeeds())
    }

    private fun getTestFeeds(): List<Feed> {
        val feeds: ArrayList<Feed> = arrayListOf()
        for (i in 1..20) {
            feeds.add(Feed(ContextCompat.getDrawable(this, if (i % 2 == 0) R.drawable.ic_1 else R.drawable.ic_2)))
        }
        return feeds
    }
}
