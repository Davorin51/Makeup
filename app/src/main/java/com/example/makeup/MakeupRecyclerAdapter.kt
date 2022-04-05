package com.example.makeup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.makeup.view.*

class MakeupRecyclerAdapter(private val items: List<Makeup>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MakeupViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.makeup, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MakeupViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MakeupViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val photoImage: ImageView = itemView.makeupImage
        private val makeupBrand = itemView.mainTitle
        private val makeupPrice: TextView = itemView.price
        private val makeupRating: TextView = itemView.rating
        private val makeupDescription: TextView = itemView.description
        private val makeupName: TextView = itemView.id1
        fun bind(makeup: Makeup){
            Glide
                .with(itemView.context)
                .load(makeup.image_link)
                .into(photoImage)



                makeupBrand.text = makeup.brand
            makeupPrice.text = makeup.price
            makeupRating.text = makeup.rating.toString()
            makeupDescription.text = makeup.description
            makeupName.text = makeup.name
        }
    }


}