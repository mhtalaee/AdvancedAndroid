package ir.goldenmind.advancedandroid.kotlinversion.db
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ir.goldenmind.advancedandroid.kotlinversion.model.Contact

class OpenDBHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    internal var db_create_query = "" +
            "CREATE TABLE tbl_contacts (" +
            " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " firstName TEXT ," +
            " lastName TEXT ," +
            " cellPhone TEXT " + ")" +
            ""

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(db_create_query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    fun insertContact(firstName: String, lastName: String, cellPhone: String): Boolean {
        try {
            var insertQuery = "INSERT INTO tbl_contacts (firstName, lastName, cellPhone) VALUES ('" +
                    firstName + "', '" + lastName + "', '" + cellPhone + "')"

            var db = this.writableDatabase
            db.execSQL(insertQuery)
            db.close()
            return true
        } catch (e: SQLException) {
            return false
        }
    }

    fun fetchContacts(): ArrayList<Contact> {
        val list = ArrayList<Contact>()

        var db = this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM tbl_contacts ORDER BY 1 DESC", null)

//        while (cursor.moveToNext()) {
//            val contact = Contact()
//            contact.id = cursor.getInt(0)
//            contact.firstName = cursor.getString(1)
//            contact.lastName = cursor.getString(2)
//            contact.cellPhone = cursor.getString(3)
//            list.add(contact)
//
//        }
        db.close()
        return list
    }

    fun deleteContact(id : Int): Boolean {
        try {
            var deleteQuery = "DELETE FROM tbl_contacts WHERE _id = " + id

            var db = this.writableDatabase
            db.execSQL(deleteQuery)
            db.close()
            return true
        } catch (e: SQLException) {
            return false
        }
    }
}