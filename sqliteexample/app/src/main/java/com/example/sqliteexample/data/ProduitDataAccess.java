package com.example.sqliteexample.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProduitDataAccess {

    private MonSQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private final String nom_table = "Produits";

    public ProduitDataAccess(MonSQLiteOpenHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public long ajouterProduit(Produit p) {

        ContentValues values = new ContentValues();
        values.put("description", p.getDescription());
        values.put("prix", p.getPrix());
        long idp = db.insert(nom_table, null, values);
        return idp;
    }

    public void supprimerProduit(int code) {

        db.delete(nom_table, " code=?", new String[]{Integer.toString(code)});

    }

    public void modifierProduit(int codeOld, Produit newProd) {

        ContentValues values = new ContentValues();
        values.put("description", newProd.getDescription());
        values.put("prix", newProd.getPrix());
        db.update(nom_table, values, "code=?", new String[]{String.valueOf(codeOld)});

    }

    public ArrayList<Produit> listerProduit() {

        ArrayList<Produit> liste = new ArrayList<Produit>();

        Cursor cursor =
                db.query(nom_table, new String[]{"code", "description", "prix"},
                        null,
                        null, null, null, "description desc", null);
//rawQuery("select * from produit",null);//

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            long code = cursor.getLong(0);
            String description = cursor.getString(1);
            float prix=cursor.getFloat(2);
            Produit pr=new Produit(description,prix);
            pr.setCode(code);
            liste.add(pr);
            cursor.moveToNext();
        }
        return liste;
    }

}
