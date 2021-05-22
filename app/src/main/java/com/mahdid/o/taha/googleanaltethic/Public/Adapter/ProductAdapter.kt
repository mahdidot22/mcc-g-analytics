package com.mahdid.o.taha.googleanaltethic.Public.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.mahdid.o.taha.googleanaltethic.Public.Constants.Constants
import com.mahdid.o.taha.googleanaltethic.Public.Details
import com.mahdid.o.taha.googleanaltethic.R
import com.mahdid.o.taha.googleanaltethic.Public.model.product
import kotlinx.android.synthetic.main.products_item.view.*

class ProductAdapter(var context: Context, var list: ArrayList<product>) :
        RecyclerView.Adapter<ProductAdapter.ProductsViewHolder>() {
    var constantt = Constants()
    var cloudDB = Firebase.analytics

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var product_name = itemView.tv_productName
        var card = itemView.Card
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.products_item, parent, false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.product_name.text = list[position].productName
        holder.card.setOnClickListener {
            constantt.navigation(position,context, Details::class.java, list)
            constantt.ClickTrak(
                    cloudDB,
                    holder.card.id.toString(),
                    holder.product_name.text.toString(),
                    "cardView"
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
