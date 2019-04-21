package ir.goldenmind.advancedandroid

import android.Manifest
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.advancedandroid.adapters.ContactListAdapter
import ir.goldenmind.advancedandroid.db.OpenDBHelper
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val db = OpenDBHelper(this@ContactListActivity, "JavaDB", null, 1)
        var list = db.fetchContacts()

        var rvAdapter = ContactListAdapter(list, { c: Contact -> contactItemClicked(c) })
        rvContactList.adapter = rvAdapter
        rvContactList.layoutManager = LinearLayoutManager(this@ContactListActivity, RecyclerView.VERTICAL, false)

        btnBack.setOnClickListener {
            finish()
        }

    }

    private fun contactItemClicked(c : Contact) {

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
