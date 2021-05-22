package com.mahdid.o.taha.googleanaltethic.Public

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.mahdid.o.taha.googleanaltethic.Public.Constants.Constants
import com.mahdid.o.taha.googleanaltethic.Public.model.product
import com.mahdid.o.taha.googleanaltethic.R
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val constant = Constants()
        val cloudDB = Firebase.analytics
        constant.ScreenTrack(cloudDB, "Details", "Product_details")
        val list = intent.getParcelableArrayListExtra<product>("list")
        val pos = intent.getIntExtra("pos", 0)
        setDetails(list!!, pos)
    }

    private fun setDetails(list: ArrayList<product>, pos: Int) {
        image.setImageResource(R.drawable.ic_grocery_store)
        pname.text = list[pos].productName
        cost.text = list[pos].ps3
        description.text = "${list[pos].ps1}\n ${list[pos].ps2}"
    }
}