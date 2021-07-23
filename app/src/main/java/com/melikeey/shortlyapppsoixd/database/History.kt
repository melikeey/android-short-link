package com.melikeey.shortlyapppsoixd.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "url")
    val url: String?,

    @ColumnInfo(name = "shortUrl")
    val shortUrl: String?,

    @ColumnInfo(name = "timeStamp")
    val timeStamp: String?
) {
    constructor(url: String?, shortUrl: String?) :
            this(0, url, shortUrl, SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(java.util.Date()))
}
