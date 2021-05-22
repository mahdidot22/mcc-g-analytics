package com.mahdid.o.taha.googleanaltethic.Public

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.mahdid.o.taha.googleanaltethic.Public.Constants.Constants
import com.mahdid.o.taha.googleanaltethic.Public.Fragments.Clothes
import com.mahdid.o.taha.googleanaltethic.Public.Fragments.Electronics
import com.mahdid.o.taha.googleanaltethic.Public.Fragments.Food
import com.mahdid.o.taha.googleanaltethic.R

class MainContainer : AppCompatActivity() {
    lateinit var constant: Constants
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
        val direction = intent.getStringExtra("data")
        val db = Firebase.analytics
        constant = Constants()
        when (direction) {
            "CFragment" -> {
                constant.transaction(supportFragmentManager, Clothes())
                constant.ScreenTrack(db,"MainContainer","Clothes")
            }
            "FFragment" -> {
                constant.transaction(supportFragmentManager, Food())
                constant.ScreenTrack(db,"MainContainer","Food")
            }
            "EFragment" -> {
                constant.transaction(supportFragmentManager, Electronics())
                constant.ScreenTrack(db,"MainContainer","Electronics")
            }
        }
    }
}