package com.example.activite9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {

    EditText edittextSMS;
    Button buttonEnvoyer,buttonAnnuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        edittextSMS = findViewById(R.id.edittextSMS);
        buttonAnnuler = findViewById(R.id.Annuler);
        buttonEnvoyer = findViewById(R.id.Envoyer);


        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smstext= edittextSMS.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("sms", smstext);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}