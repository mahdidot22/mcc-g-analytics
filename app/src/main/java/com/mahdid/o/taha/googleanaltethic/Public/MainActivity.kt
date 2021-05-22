package com.mahdid.o.taha.googleanaltethic.Public

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.mahdid.o.taha.googleanaltethic.Public.Constants.Constants
import com.mahdid.o.taha.googleanaltethic.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var constant: Constants
    lateinit var db:FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constant = Constants()
        db = Firebase.analytics
        constant.ScreenTrack(db,"MainActivity","Categories")
        btn_food.setOnClickListener {
            constant.navigation(this,"FFragment")
            constant.ClickTrak(db,btn_food.id.toString(),btn_food.text.toString(),"button")
        }

        btn_clothes.setOnClickListener {
            constant.navigation(this,"CFragment")
            constant.ClickTrak(db,btn_clothes.id.toString(),btn_clothes.text.toString(),"button")
        }

        btn_electronic.setOnClickListener {
            constant.navigation(this,"EFragment")
            constant.ClickTrak(db,btn_electronic.id.toString(),btn_electronic.text.toString(),"button")
        }
    }


}