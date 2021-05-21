package com.sumeshpandit.complexui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumeshpandit.complexui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val data:MutableList<GroceryItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter=RecyclerAdapter(data)
    }
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
}