package com.mahdid.o.taha.googleanaltethic.Public.Constants

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.mahdid.o.taha.googleanaltethic.Public.Adapter.ProductAdapter
import com.mahdid.o.taha.googleanaltethic.Public.MainContainer
import com.mahdid.o.taha.googleanaltethic.Public.model.product
import com.mahdid.o.taha.googleanaltethic.R
import kotlinx.android.synthetic.main.fragment_list.view.*

import java.io.ByteArrayOutputStream


class Constants : Application() {
    //Navigate and send data to a known activity
    fun navigation(context: Context, data: String) {
        val intent = Intent(context, MainContainer::class.java)
        intent.putExtra("data", data)
        context.startActivity(intent)
    }

    //Navigate without send data to known activity
    fun navigation(context: Context) {
        val intent = Intent(context, MainContainer::class.java)
        context.startActivity(intent)
    }

    //Navigate without send data to a specific activity
    fun navigation(context: Context, cls: Class<*>) {
        val intent = Intent(context, cls)
        context.startActivity(intent)
    }

    //Navigate and send data to a specific activity
    fun navigation(context: Context, cls: Class<*>, pname: String) {
        val intent = Intent(context, cls)
        intent.putExtra("pname", pname)
        context.startActivity(intent)
    }

    //Navigate and send data to a specific activity
    fun navigation(context: Context, cls: Class<*>, list: ArrayList<product>, pos: Int) {
        val intent = Intent(context, cls)
        intent.putExtra("list", list)
        intent.putExtra("pos", pos)
        context.startActivity(intent)
    }


    fun navigation(context: Context, cls: Class<*>, pos: Int, list: ArrayList<product>) {
        val intent = Intent(context, cls)
        intent.putExtra("list", list)
        intent.putExtra("pos", pos)
        context.startActivity(intent)
    }

    fun navigation(pos: Int, context: Context, cls: Class<*>, list: ArrayList<product>) {
        val intent = Intent(context, cls)
        intent.putExtra("list", list)
        intent.putExtra("pos", pos)
        context.startActivity(intent)
    }


    //fragmentsTransaction
    fun transaction(supportFragmentManager: FragmentManager, Fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, Fragment).commit()
    }

    fun toast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun snackbar(root: View, msg: String) {
        Snackbar.make(root, msg, Snackbar.LENGTH_SHORT).show()
    }

    fun copyArray(source: ArrayList<product>): ArrayList<product> {
        val n = source.size
        val dest = ArrayList<product>(n)
        for (i in 0 until n) {
            dest[i] = source[i]
        }
        return dest
    }

    fun getBytes(bitmap: Bitmap): ByteArray? {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream)
        return stream.toByteArray()
    }

    fun getImage(image: ByteArray): Bitmap? {
        return BitmapFactory.decodeByteArray(image, 0, image.size)
    }

    fun ClickTrak(db: FirebaseAnalytics, id: String, name: String, cType: String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, cType)
        db.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    fun ScreenTrack(db: FirebaseAnalytics, cls: String, name: String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, cls)
        db.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }

    fun food(list: ArrayList<product>, root: View, context: Context) {
        list.add(product("1", "food", "Sandwich", "Big", "With Salad", "$15"))
        list.add(product("2", "food", "Fish and Chips", "Medium", "With Sweets", "$12"))
        list.add(product("3", "food", "Burger", "Small", "With Chips", "$18"))
        val adapter = ProductAdapter(context, list)
        adapter.notifyDataSetChanged()
        root.list.layoutManager = LinearLayoutManager(context)
        root.list.adapter = adapter
    }


    fun clothes(list: ArrayList<product>, root: View, context: Context) {
        list.add(product("1", "Clothes", "T-Shirt", "Red", "Men", "$15"))
        list.add(product("2", "Clothes", "Shirt", "Yellow", "Women", "$12"))
        list.add(product("3", "Clothes", "Short", "Black", "Men", "$15"))
        list.add(product("4", "Clothes", "Socks", "White", "Both", "$2"))
        list.add(product("5", "Clothes", "Kid-Shirt", "Orange", "Kids", "$7"))
        list.add(product("6", "Clothes", "Hat", "Gray", "Both", "$5"))
        val adapter = ProductAdapter(context, list)
        root.list.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
        root.list.adapter = adapter
    }


    fun electronic(list: ArrayList<product>, root: View, context: Context) {
        list.add(product("1", "electronic", "Smart-TV", "8GB", "2.1Ghz", "$500"))
        list.add(product("2", "electronic", "Hp", "16GB", "3.2Ghz", "$1000"))
        list.add(product("3", "electronic", "Keyboard", "-", "-", "$15"))
        list.add(product("4", "electronic", "Speakers", "-", "-", "$17"))
        list.add(product("5", "electronic", "Msi", "32GB", "3.1Ghz", "3000$"))
        list.add(product("6", "electronic", "iPhone", "32GB", "3Ghz", "$2000"))
        val adapter = ProductAdapter(context, list)
        adapter.notifyDataSetChanged()
        root.list.layoutManager = LinearLayoutManager(context)
        root.list.adapter = adapter
    }

}