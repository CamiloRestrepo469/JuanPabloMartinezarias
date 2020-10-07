package com.example.taream1.basedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class basedata extends SQLiteOpenHelper {
    String tabla = "CREATE TABLE CONTACTO (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRES TEXT, TELEFONO TEXT, correo text)";
//    public String table ="CREATE TABLE contacto(id INTEGER PRIMARY KEY AUTOINCREMENT,nombres text, correo text, telefono text)";
    public basedata(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

//        db.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE CONTACTO");
        db.execSQL(tabla);

//        db.execSQL("DROP TABLE contacto");
//        db.execSQL(table);

    }
}
