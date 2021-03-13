package com.programming.android.sdu.contentproviderexercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private var contacts: List<ContactPerson>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = contacts[position]
        holder.column1.text = person.id
        holder.column2.text = person.displayName
        holder.column3.text = person.lookupKey
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder(container: View) : RecyclerView.ViewHolder(container) {
        var column1: TextView = container.findViewById(R.id.tvColumn1)
        var column2: TextView = container.findViewById(R.id.tvColumn2)
        var column3: TextView = container.findViewById(R.id.tvColumn3)
    }
}