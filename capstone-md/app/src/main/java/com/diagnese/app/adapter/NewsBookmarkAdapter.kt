package com.diagnese.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diagnese.app.components.widgets.NewsCard
import com.diagnese.app.core.data.local.NewsEntity
import com.diagnese.app.databinding.ItemNewsCardBinding

class NewsBookmarkAdapter(private val newsList : List<NewsEntity>, private val onBookmark : () -> Unit) : RecyclerView.Adapter<NewsBookmarkAdapter.ViewHolder>() {


    inner class ViewHolder(val binding : ItemNewsCardBinding) : RecyclerView.ViewHolder(binding.root){
       fun bind(newsEntity: NewsEntity){
           binding.composeView.setContent {
               NewsCard(imageUrl = newsEntity.image, title = newsEntity.title, onBookmarked = onBookmark)
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNewsCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }
}