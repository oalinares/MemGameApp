package com.oalinaresjr.memorygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
    }

    override fun getItemCount() = numPieces

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
