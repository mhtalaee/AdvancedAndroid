package ir.goldenmind.advancedandroid.kotlinversion.db

import androidx.room.Dao
import androidx.room.Query
import ir.goldenmind.advancedandroid.kotlinversion.model.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>
}