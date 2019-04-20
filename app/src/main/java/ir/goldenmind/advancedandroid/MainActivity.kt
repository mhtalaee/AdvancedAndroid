package ir.goldenmind.advancedandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import ir.goldenmind.advancedandroid.db.OpenDBHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            val db = OpenDBHelper(this@MainActivity, "JavaDB", null, 1)
            val successInsert =
                    db.insertContact(etFirstName.text.toString(), etLastName.text.toString(), etCellPhone.text.toString())
            if (successInsert) {
                Toast.makeText(this, "Insert done successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ContactListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
