package com.example.linearexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Le principe fixe
    //Declarations pour referencer les composants

        EditText txtusername;
        EditText txtpassword;
        Button btnlogin;

        //Les methodes callback de cycle de vie de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //La classe R = classe utilisé en developpement
        //c 'est une classe generée = rassembler toutes les ressources et les ids
        //inflate les composants de l'interface
        setContentView(R.layout.activity_main);

        //Lier les composants aux references
        txtusername = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpassword);
        btnlogin = findViewById(R.id.btnlogin);

        txtusername.setText("Mohamed");
       // btnlogin.setOnClickListener(new listener());
        //classe anonyme = classe interne
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CDS","Click sur le bouton login avec listener anonyme");
                Log.i("CDS","user name "+txtusername.getText());
                Log.i("CDS","password "+txtpassword.getText());

                Toast.makeText(MainActivity.this, "user name "+txtusername.getText()+"password "+txtpassword.getText(), Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public void onClick(View v) {
        Log.i("CDS","Click sur le bouton login avec listener Main");
        Log.i("CDS","user name "+txtusername.getText());
    }
}

//classe externe
class listener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        Log.i("CDS","Click sur le bouton login");
       // Log.i("CDS","user name "+txtusername.getText());
    }
}