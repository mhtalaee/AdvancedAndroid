package ir.goldenmind.advancedandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.advancedandroid.adapters.ContactListAdapter
import ir.goldenmind.advancedandroid.db.OpenDBHelper
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity(), ContactListAdapter.ListItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val db = OpenDBHelper(this@ContactListActivity, "JavaDB", null, 1)
        var list = db.fetchContacts()

        var rvAdapter = ContactListAdapter(list,this)
        rvContactList.adapter = rvAdapter
        rvContactList.layoutManager = LinearLayoutManager(this@ContactListActivity, RecyclerView.VERTICAL, false)
    }

    override fun onListItemClick(clickedItemIndex: Int) {
        var i = 0
    }
}
