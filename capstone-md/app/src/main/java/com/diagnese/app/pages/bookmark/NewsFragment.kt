package com.diagnese.app.pages.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.diagnese.app.adapter.NewsBookmarkAdapter
import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding : FragmentNewsBinding? = null
    private val binding : FragmentNewsBinding get() = _binding!!

    private val bookmarkViewModel by viewModels<BookmarkViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.newsAdapter.layoutManager = layoutManager


       bookmarkViewModel.newsList.observe(viewLifecycleOwner){
           setAdapter(bookmarkViewModel, it)
       }



    }

    private fun setAdapter(bookmarkViewModel: BookmarkViewModel, newsList: List<NewsEntity>){
        newsList.forEach { news ->
            val item = NewsEntity(image = news.image, title = news.title, author = news.author)
            val adapter = NewsBookmarkAdapter(newsList){
               bookmarkViewModel.deleteBookmark(item)
            }
            binding.newsAdapter.adapter = adapter
        }



    }


}