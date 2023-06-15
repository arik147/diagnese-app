package com.diagnese.app.pages.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diagnese.app.adapter.BookmarkViewAdapter
import com.diagnese.app.databinding.ActivityBookmarkBinding
import com.diagnese.app.pages.home.MainActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkActivity : AppCompatActivity() {

    private var _binding : ActivityBookmarkBinding? = null
    val binding : ActivityBookmarkBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookmarkViewAdapter = BookmarkViewAdapter(this)
        val viewPager = binding.viewPager
        viewPager.adapter = bookmarkViewAdapter
        val tabs : TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager){ tab, position ->
            tab.text = TABS_TITLE[position]
        }.attach()

        binding.toolbar.setNavigationOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private companion object{
        val TABS_TITLE = listOf(
            "News",
            "Saved Doctors"
        )
    }
}