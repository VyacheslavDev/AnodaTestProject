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
    private lateinit var mFeedAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFeed()
    }

    override fun onStart() {
        super.onStart()
        fillAdapter()
    }

    private fun fillAdapter() {
        mFeedAdapter.addItems(getTestFeeds())
    }

    private fun initFeed() {
        val linearLayoutManager = LinearLayoutManager(this)
        rv_feed.layoutManager = linearLayoutManager
        mFeedAdapter = FeedAdapter()
        rv_feed.adapter = mFeedAdapter
    }


    private fun getTestFeeds(): List<Feed> {
        val feeds: ArrayList<Feed> = arrayListOf()
        for (i in 1..20) {
            feeds.add(Feed(ContextCompat.getDrawable(this, if (i % 2 == 0) R.drawable.ic_1 else R.drawable.ic_2)))
        }
        return feeds
    }
}
