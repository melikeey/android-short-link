package com.melikeey.shortlyapppsoixd.shorten

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ShortenLink(
    val code: String,

    @SerializedName("short_link")
    val shortLink: String,

    @SerializedName("full_short_link")
    val fullShortLink: String,

    @SerializedName("short_link2")
    val shortLink2: String,

    @SerializedName("full_short_link2")
    val fullShortLink2: String,

    @SerializedName("share_link")
    val shareLink: String,

    @SerializedName("full_share_link")
    val fullShareLink: String,

    @SerializedName("original_link")
    val originalLink: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(shortLink)
        parcel.writeString(fullShortLink)
        parcel.writeString(shortLink2)
        parcel.writeString(fullShortLink2)
        parcel.writeString(shareLink)
        parcel.writeString(fullShareLink)
        parcel.writeString(originalLink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShortenLink> {
        override fun createFromParcel(parcel: Parcel): ShortenLink {
            return ShortenLink(parcel)
        }

        override fun newArray(size: Int): Array<ShortenLink?> {
            return arrayOfNulls(size)
        }
    }
}