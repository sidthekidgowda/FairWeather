package com.android.sidthekidgowda.fairweather.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.sidthekidgowda.fairweather.R
import com.google.android.libraries.places.api.model.AutocompletePrediction

class LocationSearchRecyclerAdapter(private val searchResults: MutableList<AutocompletePrediction>) :
    RecyclerView.Adapter<LocationSearchRecyclerAdapter.LocationSearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationSearchViewHolder {
        return LocationSearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_row, parent, false))
    }

    override fun onBindViewHolder(holder: LocationSearchViewHolder, position: Int) {
        val result = searchResults[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return searchResults.size
    }

    fun setData(searchResults: List<AutocompletePrediction>) {
        this.searchResults.clear()
        this.searchResults.addAll(searchResults)
        notifyDataSetChanged()
    }

    inner class LocationSearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //bind views
        private val textView = view.findViewById(R.id.search_result_text) as TextView

        fun bind(result: AutocompletePrediction) {
            textView.text = result.getPrimaryText(null)
        }



    }

}
