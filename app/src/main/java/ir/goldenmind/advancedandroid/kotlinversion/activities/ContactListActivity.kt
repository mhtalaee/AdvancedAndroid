package ir.goldenmind.advancedandroid.kotlinversion.activities

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import ir.goldenmind.advancedandroid.R
import ir.goldenmind.advancedandroid.kotlinversion.adapters.ContactListAdapter
import ir.goldenmind.advancedandroid.kotlinversion.model.Contact
import ir.goldenmind.advancedandroid.kotlinversion.db.AppDatabase
import ir.goldenmind.advancedandroid.kotlinversion.db.OpenDBHelper
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

//    var db1: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

//        db1 = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "appDB").build()
//        val c1 = Contact("Sara","Amidzadeh","09124262234")
//        InsertTask(this,c1).execute()
//        GetDataFromDb(this).execute()


        val db = OpenDBHelper(this@ContactListActivity, "JavaDB", null, 1)
        var list = db.fetchContacts()

        var rvAdapter = ContactListAdapter(list, { c: Contact -> contactItemClicked(c) })
        rvContactList.adapter = rvAdapter
        rvContactList.layoutManager = LinearLayoutManager(this@ContactListActivity, RecyclerView.VERTICAL, false)

        btnBack.setOnClickListener {
            finish()
        }
    }

//    private class InsertTask(var context: ContactListActivity, var contact: Contact?) : AsyncTask<Void, Void, Boolean>() {
//        override fun doInBackground(vararg params: Void?): Boolean {
//            context.db1?.contactDao()?.insertAll(contact)
//            return true
//        }
//
//        override fun onPostExecute(bool: Boolean?) {
//            if (bool!!) {
//                Toast.makeText(context, "Added to Database", Toast.LENGTH_LONG).show()
//            }
//        }
//    }


//    private class GetDataFromDb(var context: ContactListActivity) : AsyncTask<Void, Void, List<Contact>>() {
//        override fun doInBackground(vararg params: Void?): List<Contact> {
//            return context.db1!!.contactDao().getAll()
//        }
//        override fun onPostExecute(contactList: List<Contact>?) {
//            if (contactList!!.size > 0) {
//                Toast.makeText(context, contactList.get(0).id.toString(), Toast.LENGTH_LONG).show()
//            }
//        }
//    }

    private fun contactItemClicked(c: Contact) {

        val alertDialogBuilder = AlertDialog.Builder(this@ContactListActivity)
        alertDialogBuilder.setTitle("Warning")
        alertDialogBuilder.setMessage("Delete contact of " + c.firstName + " " + c.lastName + "?")
        alertDialogBuilder.setIcon(R.drawable.abc_btn_colored_material)
        alertDialogBuilder.setCancelable(java.lang.Boolean.FALSE)

        alertDialogBuilder.setPositiveButton("Yes") { dialog, which ->
            val db = OpenDBHelper(this@ContactListActivity, "JavaDB", null, 1)
            db.deleteContact(c.id!!)
            var list = db.fetchContacts()
            var rvAdapter = ContactListAdapter(list, { c: Contact -> contactItemClicked(c) })
            rvContactList.adapter = rvAdapter
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, which ->

        }

        val dialog = alertDialogBuilder.create()
        dialog.show()

    }
}
