package ir.goldenmind.advancedandroid.kotlinversion.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.goldenmind.advancedandroid.kotlinversion.model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}