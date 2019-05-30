package ir.goldenmind.advancedandroid.kotlinversion.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(

    @ColumnInfo(name = "firs_name") var firstName: String,
    @ColumnInfo(name = "last_name") var lastName: String,
    @ColumnInfo(name = "cell_phone") var cellPhone: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
