package app.diary.kotlin.farm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import app.diary.kotlin.farm.database.AppDatabase
import app.diary.kotlin.farm.database.User
import farm.R
import kotlinx.android.synthetic.main.activity_diary.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DiaryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        btn_add.setOnClickListener {
            addData()
        }

    }

    private fun addData() {



         val db = AppDatabase.getInstance(application)

        GlobalScope.launch {
            db.diaryDao().insertUser(User(1, "admin1","admin"))
            db.diaryDao().insertUser(User(2, "admin2","admin"))
            db.diaryDao().insertUser(User(3, "admin3","admin"))
            db.diaryDao().insertUser(User(4, "admin4","admin"))
            db.diaryDao().insertUser(User(5, "admin5","admin"))
            db.diaryDao().insertUser(User(6, "admin6","admin"))
            db.diaryDao().insertUser(User(7, "admin7","admin"))

            val data: List<User>?
            data = db.diaryDao().getAllUser()
            var text1 :String = ""
            data.forEach {
                text1 = text1 + it.toString()
            }

            tv_data.text =text1
        }

    }

}