package com.mahdid.o.taha.googleanaltethic.Public.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahdid.o.taha.googleanaltethic.Public.Constants.Constants
import com.mahdid.o.taha.googleanaltethic.Public.model.product
import com.mahdid.o.taha.googleanaltethic.R

class Electronics : Fragment() {
    lateinit var constants: Constants
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        constants = Constants()
        val root = inflater.inflate(R.layout.fragment_list, container, false)
        var list = arrayListOf<product>()
        constants.electronic(list,root,context!!)
        return root
    }


}