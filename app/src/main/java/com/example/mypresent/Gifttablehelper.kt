package com.example.mypresent

import android.content.ContentValues
import android.content.Context
import android.util.Log
import java.sql.SQLException

class Gifttablehelper(context: Context){
    private val helper = DataBaseHelper(context)

    fun speichereNeuenEintrag(daten : GiftObject) : Long{
        val db = helper.writableDatabase
        val datensatz = ContentValues()
        datensatz.put(databaseValues.NAME, daten.name)
        datensatz.put(databaseValues.BESCHREIBUNG, daten.beschreibung)
        datensatz.put(databaseValues.GEKAUFT, daten.gekauft)
        datensatz.put(databaseValues.GESCHENK_FUER, daten.geschenkFuer)
        datensatz.put(databaseValues.SHOP, daten.shop)
        datensatz.put(databaseValues.BILD_ID, daten.id)

        db.beginTransaction()
        val id = try {
            val id = db.insert(databaseValues.TABLE_NAME, null, datensatz)
            db.setTransactionSuccessful()
            id
        }
        finally {
            db.endTransaction()
            db.close()
        }
        Log.i("Test", "Datensatz eingefügt $id")
        return id
    }
}