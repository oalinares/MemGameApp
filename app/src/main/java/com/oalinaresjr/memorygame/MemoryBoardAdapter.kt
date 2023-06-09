package com.oalinaresjr.memorygame

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.oalinaresjr.memorygame.models.BoardSize
import kotlin.math.min

class MemoryBoardAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cardImages: List<Int>) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object {
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }

    //onCreateViewHolder is responsible for figuring out how to create one view of our RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth = parent.width / boardSize.getWidth() - (2 * MARGIN_SIZE)
        val cardHeight = parent.height / boardSize.getHeight() - (2 * MARGIN_SIZE)
        val cardSideLength = min(cardWidth, cardHeight)
        val view = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as MarginLayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }
    //getItemCount is how many elements are in our RecyclerView
    override fun getItemCount() = boardSize.numCards

    /* onBindViewHolder is responsible for taking the data which is at this position and binding it to the passed
    ViewHolder*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position
        )
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setImageResource(cardImages[position])
            imageButton.setOnClickListener {
                Log.i(TAG, "Clicked on position $position")
            }
        }
    }
}
