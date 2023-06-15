package com.diagnese.app.core.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("news")
data class NewsEntity(

    @ColumnInfo(name = "image")
    val image : String? = null,

    @PrimaryKey
    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "author")
    val author : String,

)