package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqliteexample.adapters.ProduitAdapter;
import com.example.sqliteexample.data.MonSQLiteOpenHelper;
import com.example.sqliteexample.data.Produit;
import com.example.sqliteexample.data.ProduitDataAccess;

public class MainActivity extends AppCompatActivity {

    private MonSQLiteOpenHelper helper;
    private EditText txtDesc;
    private EditText txtPrix;
    private ProduitDataAccess data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setTitle("Gestion produits");
        helper = new MonSQLiteOpenHelper(this, "data.db", null, 1);
        data = new ProduitDataAccess(helper);

       /* Produit p1=new Produit("produit 1",150);
        Produit p2=new Produit("produit 2",300);

        data.ajouterProduit(p1);
        data.ajouterProduit(p2)*/;
        actualiser();

    }

    private void actualiser() {

        ListView listeV = (ListView) findViewById(R.id.listeView);
        registerForContextMenu(listeV);
        ProduitAdapter adapter = new ProduitAdapter(this,
                data.listerProduit());
        listeV.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }

}