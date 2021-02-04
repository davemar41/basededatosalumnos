package com.example.basedealumnos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase.CursorFactory


class BasededatosLite(context: Context,name:String,factory: SQLiteDatabase.CursorFactory?,version:Int):SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table misalumnos(codigo int primary key,nombre text,lugar text,horario text,precio text, deberes text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}