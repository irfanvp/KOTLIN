package app.diary.kotlin.farm

import retrofit2.Call
import retrofit2.http.*

interface WeatherService {
    @GET("todos/1")
    fun login() : Call<DataItem>

    @GET("posts")
    fun posts() : Call<PostData>

    @Headers("Content-Type: application/json")
    @POST("posts")
    fun postObject(@Body postData: PostData.PostDataItem): Call<PostData.PostDataItem>

}