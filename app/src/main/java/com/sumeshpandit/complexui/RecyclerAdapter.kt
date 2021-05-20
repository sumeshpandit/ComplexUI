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

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{

    private val data:MutableList<GroceryItem> = mutableListOf()

    init {
        data.add(GroceryItem(R.mipmap.item1, "Super sale", 10,"BB ROYALE","Tomato- Hybrid","1kg",100,3,234))
        data.add(GroceryItem(R.mipmap.item2, "Super sale", 12,"TATA","Onion","500g",343,5,34))
        data.add(GroceryItem(R.mipmap.item3, "", 23,"AASHIRWAD","potato","2kg",234,2,125))
        data.add(GroceryItem(R.mipmap.item4, "", 41,"FORTUNE","Peas","10kg",231,3,923))
        data.add(GroceryItem(R.mipmap.item5, "super sale", 0,"EMAMI","Apple","1kg",201,4,87))
        data.add(GroceryItem(R.mipmap.item6, "", 17,"Rajdhani","Milk","1.5kg",534,5,0))
        data.add(GroceryItem(R.mipmap.item7, "super sale", 0,"Fresho","Grapes","5kg",199,2,32))

        data.add(GroceryItem(R.mipmap.item8, "super sale", 13,"BB Royale","Almonds","5kg",1939,2,322))
        data.add(GroceryItem(R.mipmap.item9, "", 34,"Amazon","Keyboard","1kg",1399,5,3212))

        data.add(GroceryItem(R.mipmap.item10, "super sale", 43,"Flipkart","Mouse","1pc",1499,2,432))

        data.add(GroceryItem(R.mipmap.item11, "super sale", 23,"Google","Laptop","2pc",5199,3,362))

        data.add(GroceryItem(R.mipmap.item12, "super sale", 23,"Microsoft","Monitor","8pc",5199,5,392))

        data.add(GroceryItem(R.mipmap.item13, "super sale", 67,"Apple","Tablet","12pc",1949,4,362))

        data.add(GroceryItem(R.mipmap.item14, "", 45,"Ola","Phone","12oz",19239,5,362))

        data.add(GroceryItem(R.mipmap.item15, "super sale", 67,"Uber","Scooter","2pc",19239,4,329))

        data.add(GroceryItem(R.mipmap.item16, "super sale", 76,"Snapchat","Ice-cream","9kg",1199,3,832))

        data.add(GroceryItem(R.mipmap.item17, "", 12,"Facebook","Water","200gm",1959,1,362))

        data.add(GroceryItem(R.mipmap.item18, "", 76,"Bloomberg","Cold Drink","270gm",1969,4,322))

        data.add(GroceryItem(R.mipmap.item19, "super sale", 45,"Adobe","Sprite","200gm",3199,6,352))

        data.add(GroceryItem(R.mipmap.item20, "super sale", 12,"Cisco","AC","50kg",1979,4,332))


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
        var ratingLayout=binding.ratingLayout
        private val addButton:Button= binding.addButton
        init {
            addButton.setOnClickListener {
                if(addButton.text=="Delete"){
                    addButton.setText(R.string.add)
                    addButton.setTextColor(Color.WHITE)
                    addButton.setBackgroundColor(Color.argb(1,255,68,68))
                }
                else {
                    addButton.setText(R.string.delete)
                    addButton.setBackgroundColor(Color.GREEN)
                    addButton.setTextColor(Color.BLACK)
                }
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
        val offText="${off}% off"

        if(off!=0) {
            holder.offText.visibility = View.VISIBLE
            holder.originalPrice.visibility = View.VISIBLE
            holder.offText.text = offText
        }


        holder.company.text= data[position].company

        holder.size.text= data[position].itemSize

        val discountedPrice=((data[position].price)*(100-data[position].off))/100
        val discountedPriceFinal="Rs $discountedPrice"
        val originalPriceFinal="Rs ${data[position].price}"
        holder.price.text= discountedPriceFinal
        holder.originalPrice.text=originalPriceFinal
        holder.originalPrice.paintFlags=Paint.STRIKE_THRU_TEXT_FLAG

        holder.itemName.text=data[position].itemName

        holder.star.text=data[position].star.toString()
        val rating=data[position].rating
        val ratingFinal="$rating Ratings"
        holder.rating.text=ratingFinal
        if(rating!=0)
            holder.ratingLayout.visibility=LinearLayout.VISIBLE
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
