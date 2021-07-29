package app.diary.kotlin.farm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
        entities = [User::class, Cow::class],
        version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun diaryDao(): DiaryDao


    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        @Synchronized
        fun getInstance(ctx: Context): AppDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java,
                        "diary")
                        .fallbackToDestructiveMigration()
                        .build()

            return instance!!

        }
    }
}
