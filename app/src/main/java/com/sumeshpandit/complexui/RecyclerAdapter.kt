package com.sumeshpandit.complexui

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sumeshpandit.complexui.databinding.ItemBinding

class RecyclerAdapter(private val data: MutableList<GroceryItem>, val customClickListener: AddButtonListener): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{
    inner class ViewHolder(binding: ItemBinding):RecyclerView.ViewHolder(binding.root) {
        val itemImage:ImageView= binding.itemImage
        val offer:TextView= binding.offer
        val offText:TextView= binding.off
        val company:TextView= binding.company
        val size:TextView= binding.size
        val price:TextView= binding.price
        val originalPrice:TextView=binding.originalPrice
        val itemName: TextView= binding.itemName
        val star: TextView= binding.stars
        val rating: TextView= binding.rating
        val addButton:Button= binding.addButton

        init {
            addButton.setOnClickListener {
                val position= adapterPosition
                customClickListener.onClick(position, binding.addButton)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemBinding = ItemBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemImage.setImageResource(data[position].itemImageView)

        val offer=data[position].offer
        if(offer!="") {
            holder.offer.text = offer
            holder.offer.visibility = View.VISIBLE
        }
        else
            holder.offer.visibility=View.GONE


        val off=data[position].off
        if(off!=0) {
            holder.offText.visibility = View.VISIBLE
            val offText="${off}% off"
            holder.offText.text = offText
        }
        else
            holder.offText.visibility=View.GONE


        holder.company.text= data[position].company

        holder.size.text= data[position].itemSize

        val discountedPrice=((data[position].price)*(100-data[position].off))/100
        val discountedPriceFinal="Rs $discountedPrice"
        val originalPriceFinal="Rs ${data[position].price}"
        holder.price.text= discountedPriceFinal

        if(off!=0){
            holder.originalPrice.visibility = View.VISIBLE
            holder.originalPrice.text=originalPriceFinal
            holder.originalPrice.paintFlags=Paint.STRIKE_THRU_TEXT_FLAG

        }
        else{
            holder.originalPrice.visibility=View.GONE
        }

        holder.itemName.text=data[position].itemName

        holder.star.text=data[position].star.toString()
        val rating=data[position].rating
        val ratingFinal="$rating Ratings"
        holder.rating.text=ratingFinal
        if(rating!=0) {
            holder.star.visibility = View.VISIBLE
            holder.rating.visibility = View.VISIBLE
        }
        else {
            holder.star.visibility=View.INVISIBLE
            holder.rating.visibility=View.INVISIBLE
        }

        val isAdded=data[position].isAdded
        val addButton=holder.addButton

        if(!isAdded){
            addButton.setText(R.string.add)
            addButton.setTextColor(Color.WHITE)
            addButton.setBackgroundColor(Color.argb(1,255,68,68))
        }
        else{
            addButton.setText(R.string.delete)
            addButton.setBackgroundColor(Color.GREEN)
            addButton.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface AddButtonListener{
        fun onClick(position: Int, addButton:Button)
    }

}
