package com.example.mypresent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ShoppingListAdapter(private val context: Context, private val items: ArrayList<GiftObject>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val inflater = layoutInflater.inflate(R.layout.shopping_list_layout, parent, false)
        val title = inflater.findViewById<TextView>(R.id.textViewProduct)
        val bild = inflater.findViewById<ImageView>(R.id.imageViewCat)
        title.text = items.get(position).name
        bild.setImageResource(items.get(position).bild)
        return inflater
    }

    override fun getItem(position: Int): Any {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}