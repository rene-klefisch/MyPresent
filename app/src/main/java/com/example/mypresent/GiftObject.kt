package com.example.mypresent

import android.graphics.drawable.Drawable
import android.provider.BaseColumns

data class GiftObject(val id: Int, val name : String, val gekauft : Boolean, val shop : String, val beschreibung: String, val bild : Int, val geschenkFuer : String)

object databaseValues : BaseColumns{
    val DATABASE_NAME = "giftdb"
    val DATABASE_VERSION = 1
    val TABLE_NAME = "gifttable"
    val _ID = "_id"
    val NAME = "name"
    val GEKAUFT = "gekauft"
    val SHOP = "shop"
    val BESCHREIBUNG = "beschreibung"
    val BILD_ID = "bildid"
    val GESCHENK_FUER = "geschenkfuer"
}