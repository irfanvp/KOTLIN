package app.diary.kotlin.farm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import farm.R
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val title : String? = intent.getStringExtra("title")

        tv_newtextview.text = title

        tv_newtextview.setOnClickListener {

            posts()
        }

        tv_hello.setOnClickListener {

            if (tv_hello.text.toString().equals("hello", ignoreCase = true)) {

                val postData: PostData.PostDataItem = PostData.PostDataItem("", 0, "", 0)

                postData.body = "HELLO"
                postData.id = 100
                postData.title = "hello"
                postData.userId = 100

                postObject(postData)

            }

        }


    }


    private fun posts(){

        val retrofit = Retrofit.Builder()
                .baseUrl(MainActivity.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.posts()

        call.enqueue(object : Callback<PostData> {
            override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
                if (response.code() == 200) {

                    val response1 = response.body()!!
                    var stringBuilder = ""
                    for(element in response1){

                        stringBuilder= stringBuilder+"ID:"+element.id+"\n"+"Body:"+element.body+"\n"+"title:"+element.title+"\n"+"userid:"+element.userId+"\n"

                    }

                    tv_newtextview.text=stringBuilder
                }
            }
            override fun onFailure(call: Call<PostData>, t: Throwable) {
                Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
            }
        })


    }

    private fun postObject(postdata :PostData.PostDataItem){

        val retrofit = Retrofit.Builder()
                .baseUrl(MainActivity.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.postObject(postdata)

        call.enqueue(object : Callback<PostData.PostDataItem> {
            override fun onResponse(call: Call<PostData.PostDataItem>, response: Response<PostData.PostDataItem>) {
                if (response.code() == 200) {

                    val response1 = response.body()!!
                    val stringBuilder = response1.toString()
                    tv_newtextview.text=stringBuilder
                    tv_hello.text =""

                }
            }
            override fun onFailure(call: Call<PostData.PostDataItem>, t: Throwable) {
                Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
            }
        })


    }


}