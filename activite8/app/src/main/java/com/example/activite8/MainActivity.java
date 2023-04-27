package com.example.activite8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    Button btnvalider;
    EditText edittextUserName,edittextpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnvalider = findViewById(R.id.btnvalider);

        edittextUserName = findViewById(R.id.edittextusername);
        edittextpassword = findViewById(R.id.edittextpassword);

        btnvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username= edittextUserName.getText().toString();
                String password=edittextpassword.getText().toString();

                if(username.trim().equals("") || password.equals(""))
                    return;

                if(username.equals("admin") && password.equals("123"))
                {
                    //Intent explicite
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}