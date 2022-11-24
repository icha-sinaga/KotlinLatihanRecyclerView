package com.example.latihanrecylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TourListAdapter(private val tour: ArrayList<Tour>): RecyclerView.Adapter<TourListAdapter.TourViewHolder>(){
    class TourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textViewName: TextView = itemView.findViewById(R.id.textViewName)
        var textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val photoView: ImageView = itemView.findViewById(R.id.photoView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_list_item, parent, false)
        return TourViewHolder(view)
        //mengkaitkan list item dengan adapater

    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val (name, description, photo) = tour[position]
        holder.textViewName.text = name
        holder.textViewDescription.text = description
        holder.photoView.setImageResource(photo)
    }

    override fun getItemCount(): Int {
        return tour.size
    }
}
