package app.diary.kotlin.farm

import com.google.gson.annotations.SerializedName

class DataItem {

    val abc:Int =10


    @SerializedName("userId")
    val userId :Int =0

    @SerializedName("passId")
    val passId :Int =0

    @SerializedName("id")
    val id :Int =0

    @SerializedName("title")
    val title :String? =null

    @SerializedName("completed")
    val completed :String? =null



}