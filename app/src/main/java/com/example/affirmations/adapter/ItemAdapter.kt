package com.example.affirmations.adapter

//Meingport Context, LayoutInflater, View, ViewGroup, TextView, RecyclerView, R dan model Affirmation
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

//Membuat Constructor ItemAdaptor class dan mengextendnya dengan kelas abstrak RecyclerView.Adapter
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    //Membuat nested class dengan nama ItemViewHolder untuk menyimpan refrensi tampilan individu
    //dalam layout item list dan mempermudah untuk memperbarui item list
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    // onCreateViewHolder digunakan untuk membuat tampilan baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    // onBindViewHolder digunakan untuk mengganti isi tampilan
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringResourceId)
    }

    // getitemcount digunakn dengan nilai kembalian dataset.size
    override fun getItemCount(): Int {
        return dataset.size
    }
}