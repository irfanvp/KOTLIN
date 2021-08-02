package app.diary.kotlin.farm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import farm.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//import kotlinx.android.synthetic.main.MainActivity.*


class MainActivity : AppCompatActivity() {
    var username: String = ""
    var password: String =""
    var password1: String =""
    companion object {
        var BaseUrl :String ="https://jsonplaceholder.typicode.com/"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener(View.OnClickListener {

             username  = et_username.text.toString()
             password  = et_password.text.toString()
            if(username.isNullOrEmpty()||password.isNullOrEmpty()){
                Toast.makeText(this,"Username or password is not correct",Toast.LENGTH_LONG).show();
            }else{
                login()
            }

        })
    }

    fun login(){

        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.login()

        call.enqueue(object : Callback<DataItem> {
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                if (response.code() == 200) {

                    val response1 = response.body()!!
                    val stringBuilder = "ID:"+response1.id+"\nTitle:"+response1.title
                    Toast.makeText(applicationContext,stringBuilder,Toast.LENGTH_LONG).show();
                    val intent = Intent(applicationContext, DiaryActivity::class.java)
                    intent.putExtra("title",stringBuilder)
                    startActivity(intent)

                }
            }
            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                Toast.makeText(applicationContext,"failed",Toast.LENGTH_LONG).show();
            }
        })


    }



}
