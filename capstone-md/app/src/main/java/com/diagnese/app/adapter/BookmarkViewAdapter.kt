package com.diagnese.app.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.diagnese.app.pages.bookmark.MapsFragment
import com.diagnese.app.pages.bookmark.NewsFragment

class BookmarkViewAdapter(activity : AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position){
            0 -> fragment = NewsFragment()
            1 -> fragment = MapsFragment()
        }
        return fragment as Fragment
    }

}