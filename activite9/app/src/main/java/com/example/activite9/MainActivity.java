package com.example.activite9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activite9.model.Contact;
import com.example.activite9.model.ManageContact;

public class MainActivity extends AppCompatActivity {

    private static int request_newConact=1;
    private static int request_SMS=2;

    //La liste des contacts
    public static ManageContact manageContacts;

    Contact currentContact;
    //Controles

    TextView textviewName, textviewnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewName = findViewById(R.id.textViewname);
        textviewnumber = findViewById(R.id.textViewnumber);

        //creer les contacts
        manageContacts = new ManageContact(this);

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
                callContact(currentContact);
                break;
            case R.id.itemSMS:
                Intent intent1 =new Intent(this, SMSActivity.class);
                //  startActivity(intent);
                //changer la fonction startActivity à startActiivityForResult
                startActivityForResult(intent1,request_SMS);
                Toast.makeText(this, "SMS item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemNew:

                Intent intent2 =new Intent(this, NewContactActivity.class);
                //  startActivity(intent);
                //changer la fonction startActivity à startActiivityForResult
                startActivityForResult(intent2,request_newConact);
                break;
        }

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
         currentContact= manageContacts.getContactParPosition(0);
        if(currentContact != null)
        {
            textviewName.setText(currentContact.getName());
            textviewnumber.setText(currentContact.getPhoneNumber());
        }

    }

    private void callContact(Contact contact)
    {
        try {
            Uri uri = Uri.parse("tel:"+contact.getPhoneNumber());
            Intent intent =new Intent(Intent.ACTION_CALL,uri);
            startActivity(intent);
        }
        catch(Exception ex)
        {

        }
    }

    //gerer le feedback des sous activites
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == request_newConact && resultCode == RESULT_OK)
        {
            Contact contact =(Contact) data.getSerializableExtra("contact");
            Toast.makeText(this, "contact :"+contact.getName(), Toast.LENGTH_SHORT).show();
        }
        if(requestCode == request_newConact && resultCode == RESULT_CANCELED)
        {
            Toast.makeText(this, "Utilisateur a annulé :", Toast.LENGTH_SHORT).show();
        }
        if(requestCode == request_SMS && resultCode == RESULT_OK)
        {
                String smstext= data.getStringExtra("sms");
            Toast.makeText(this, smstext, Toast.LENGTH_SHORT).show();
        }
        if(requestCode == request_SMS && resultCode == RESULT_CANCELED)
        {
            Toast.makeText(this, "Utilisateur a annulé :", Toast.LENGTH_SHORT).show();
        }
    }
}