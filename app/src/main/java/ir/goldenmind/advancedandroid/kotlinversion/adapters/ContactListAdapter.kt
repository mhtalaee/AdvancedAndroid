package ir.goldenmind.advancedandroid.kotlinversion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.advancedandroid.kotlinversion.model.Contact
import ir.goldenmind.advancedandroid.R
import kotlinx.android.synthetic.main.contact_recyclerview_item.view.*

class ContactListAdapter(contactList: List<Contact>, val clickListener: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {

    val contactList = contactList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_recyclerview_item, parent, false)
        val viewHoler = ContactViewHolder(v)
        return viewHoler
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

//        val contact = contactList.get(position)
//        holder.tvFullName.text = contact.firstName + " " + contact.lastName
//        holder.tvCellPhone.text = contact.cellPhone
        (holder as ContactViewHolder).bind(contactList[position], clickListener)



    }

    override fun getItemCount(): Int {

        return contactList.size
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(c: Contact, clickListener: (Contact) -> Unit) {
            val tvFullName = itemView.tvFullName
            val tvCellPhone = itemView.tvPhone

            tvFullName.text = c.firstName + " " + c.lastName
            tvCellPhone.text = c.cellPhone
            itemView.setOnClickListener { clickListener(c) }
        }

    }

}