package app.diary.kotlin.farm.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class Cow(
        @PrimaryKey(autoGenerate = true) var id: Int,
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "dateofins") var dateOfins: String,
        @ColumnInfo(name = "image") var image: String,
        @ColumnInfo(name = "details") var details: String
)
