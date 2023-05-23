package com.example.sqliteexample.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MonSQLiteOpenHelper extends SQLiteOpenHelper {

    //Obligatoire
    public MonSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Obligatoire
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String requete=
                "CREATE TABLE Produits(code integer primary key autoincrement, description text, prix real)";

        sqLiteDatabase.execSQL(requete);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE if exists Produits");
        onCreate(sqLiteDatabase);
    }

    @Override
    public synchronized void close() {
        super.close();
    }
}
