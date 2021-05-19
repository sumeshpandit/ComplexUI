package com.sumeshpandit.complexui

import android.content.ContentValues.TAG
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sumeshpandit.complexui.databinding.ItemBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{

    private val data:MutableList<GroceyItem> = mutableListOf()

    init {
        data.add(GroceyItem(R.mipmap.item1, "Super sale", 10,"BB ROYALE","Tomato- Hybrid","1kg",100,3,234))
        data.add(GroceyItem(R.mipmap.item2, "Super sale", 12,"TATA","Onion","500g",343,5,34))
        data.add(GroceyItem(R.mipmap.item3, "Super sale", 23,"AASHIRWAD","potato","2kg",234,2,125))
        data.add(GroceyItem(R.mipmap.item4, "super sale", 41,"FORTUNE","Peas","10kg",231,3,923))
        data.add(GroceyItem(R.mipmap.item5, "super sale", 16,"EMAMI","Apple","1kg",201,4,87))
        data.add(GroceyItem(R.mipmap.item4, "super sale", 17,"Rajdhani","Milk","1.5kg",534,5,453))
        data.add(GroceyItem(R.mipmap.item4, "super sale", 65,"Fresho","Grapes","5kg",199,2,32))
    }

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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemBinding = ItemBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(data[position].itemImageView)
        holder.offer.text=data[position].offer
        holder.offText.text= "${data[position].off}% off"
        holder.company.text= data[position].company
        holder.size.text= data[position].itemSize
        val discountedPrice=((data[position].price)*(100-data[position].off))/100
        holder.price.text= "Rs $discountedPrice"
        holder.originalPrice.text="Rs ${data[position].price}"
        holder.originalPrice.paintFlags=Paint.STRIKE_THRU_TEXT_FLAG
        holder.itemName.text=data[position].itemName
        holder.star.text=data[position].star.toString()
        val rating=data[position].rating
        holder.rating.text="$rating Ratings"
    }

    override fun getItemCount(): Int {
        Log.e(TAG, "getItemCount: ${data.size}", )
        return data.size
    }

}
