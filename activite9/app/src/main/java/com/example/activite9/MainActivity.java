package com.example.activite9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activite9.model.Contact;
import com.example.activite9.model.ManageContact;

public class MainActivity extends AppCompatActivity {

    //La liste des contacts
    public static ManageContact manageContacts=new ManageContact();

    //Controles

    TextView textviewName, textviewnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewName = findViewById(R.id.textViewname);
        textviewnumber = findViewById(R.id.textViewnumber);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id)
        {
            case R.id.itemCall:
                Toast.makeText(this, "call item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemSMS:
                Toast.makeText(this, "SMS item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemNew:

                Intent intent =new Intent(this, NewContactActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Contact contact= manageContacts.getContactParPosition(0);
        if(contact != null)
        {
            textviewName.setText(contact.getName());
            textviewnumber.setText(contact.getPhoneNumber());
        }

    }
}