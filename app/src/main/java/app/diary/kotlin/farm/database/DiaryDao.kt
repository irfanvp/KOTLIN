package app.diary.kotlin.farm.database

import androidx.room.*

@Dao
interface DiaryDao {

    @Query("SELECT * FROM User")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM User WHERE name = :name and password = :password")
    fun findUser(name: String,password:String): User

    @Insert
    fun insertUser(vararg user: User)

    @Insert
    fun insertCow(vararg cow: Cow)

//    @Query("SELECT * FROM Cow")
//    fun getAllCow(): List<Cow>

    @Delete
    fun deleteCow(cow: Cow)

    @Update
    fun updateCow(vararg cow: Cow)

}