package com.mahdid.o.taha.googleanaltethic.Public.model

import android.os.Parcel
import android.os.Parcelable

data class product(
        val id: String?,
        val category: String?,
        val productName: String?,
        val ps1: String?,
        val ps2: String?,
        val ps3: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(category)
        parcel.writeString(productName)
        parcel.writeString(ps1)
        parcel.writeString(ps2)
        parcel.writeString(ps3)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<product> {
        override fun createFromParcel(parcel: Parcel): product {
            return product(parcel)
        }

        override fun newArray(size: Int): Array<product?> {
            return arrayOfNulls(size)
        }
    }

}