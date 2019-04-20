package ir.goldenmind.advancedandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.advancedandroid.Contact
import ir.goldenmind.advancedandroid.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.contact_recyclerview_item.view.*

class ContactListAdapter(contactList: List<Contact>, private val mOnClickListener: ListItemClickListener) : RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {

    val contactList = contactList


    interface ListItemClickListener {
        fun onListItemClick(clickedItemIndex: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_recyclerview_item, parent, false)
        val viewHoler = ContactViewHolder(v)
        return viewHoler
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact = contactList.get(position)
        holder.tvFullName.text = contact.firstName + " " + contact.lastName
        holder.tvCellPhone.text = contact.cellPhone

    }

    override fun getItemCount(): Int {

        return contactList.size
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            val tvFullName = itemView.tvFullName
            val tvCellPhone = itemView.tvPhone

        override fun onClick(v: View?) {
            val clickedPosition = getAdapterPosition()
            mOnClickListener.onListItemClick(clickedPosition)

        }

    }

}