package com.example.activite6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.activite6_2.adapter.Logiciel;
import com.example.activite6_2.adapter.MonAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Logiciel> data= new ArrayList<Logiciel>();

    //referencer le liste

    ListView liste1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //remplir la liste

        data.add(new Logiciel("Word","Editeur de texte",R.drawable.word));
        data.add(new Logiciel("Execel","Tableur",R.drawable.excel));
        data.add(new Logiciel("PowrPoint","Editeur de presentation",R.drawable.power));
        data.add(new Logiciel("Outlook","client de messagerie",R.drawable.outlook));


        liste1= findViewById(R.id.list1);

        MonAdapter adapter= new MonAdapter(this, data);

        liste1.setAdapter(adapter);
    }
}