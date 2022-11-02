package com.celfocus.data.api

import com.google.gson.annotations.SerializedName

data class Response<T> (
    @SerializedName("page") var page: Int = 0,
    @SerializedName("per_page") var per_page: Int = 0,
    @SerializedName("total") var total: Int = 0,
    @SerializedName("total_pages") var total_pages: Int = 0,
    @SerializedName("data") var data: MutableList<T>
)