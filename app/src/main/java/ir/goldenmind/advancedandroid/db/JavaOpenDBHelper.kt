package ir.goldenmind.advancedandroid.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JavaOpenDBHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    internal var db_create_query = "" +
            "CREATE TABLE tblCity (" +
            " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " city TEXT ," +
            " tem TEXT " + ")" +
            ""
    val cities: String
        get() {
            var test = ""
            val db = this.readableDatabase
            val cursor = db.rawQuery("SELECT city from tblCity ", null)
            while (cursor.moveToNext()) {
                test += cursor.getString(0) + "\n"
            }
            db.close()
            return test
        }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(db_create_query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    fun inserToDB(city: String, tem: Int) {
        val insertQuery = "INSERT INTO tblCity " +
                "(city , tem)" +
                "VALUES( '" + city + "' , " + tem + " )"
        val db = this.writableDatabase
        db.execSQL(insertQuery)
        db.close()
    }

}
