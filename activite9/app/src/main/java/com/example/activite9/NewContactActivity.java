package com.example.activite9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.activite9.model.Contact;

public class NewContactActivity extends AppCompatActivity {


    EditText editname,editphone;
    Button buttonadd, buttoncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        editname = findViewById(R.id.editname);
        editphone = findViewById(R.id.editphone);
        buttonadd = findViewById(R.id.buttonadd);
        buttoncancel = findViewById(R.id.buttoncancel);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= editname.getText().toString();
                String phone = editphone.getText().toString();

                Contact contact = new Contact(name, phone);
                Intent intent = new Intent();
                intent.putExtra("contact",contact);
                setResult(RESULT_OK,intent);
                //Ajouter le contact dans la liste
                //MainActivity.manageContacts.add(contact);
                finish();
            }
        });

        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}