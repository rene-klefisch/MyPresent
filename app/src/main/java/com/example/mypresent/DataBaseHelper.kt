package com.example.mypresent

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, databaseValues.DATABASE_NAME, null, databaseValues.DATABASE_VERSION) {

    val tabelle = "CREATE TABLE gifttable (_id INTEGER PRIMARY KEY, name TEXT, gekauft BOOLEAN, shop TEXT, beschreibung TEXT, bildid INTEGER, geschenkfuer TEXT)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(tabelle)
        Log.i("Test", "Tabelle angelegt!")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${databaseValues.TABLE_NAME}")
        db.execSQL(tabelle)
        Log.i("Test", "Tabelle gelöscht und neu angelegt!")
    }
}