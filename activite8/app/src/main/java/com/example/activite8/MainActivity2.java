package com.example.activite8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activite8.io.IOFile;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    EditText edittextnewfile, edittexttextaecrire, edittextfiletoread;

    Button btnWrite, btnRead;
   TextView textviewread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edittextnewfile = findViewById(R.id.edittextnewfile);
        edittexttextaecrire = findViewById(R.id.edittexttextaecrire);

        edittextfiletoread = findViewById(R.id.edittextfiletoread);

        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        textviewread = findViewById(R.id.textviewread);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname= edittextnewfile.getText().toString();
                String contenu= edittexttextaecrire.getText().toString();

                if(fname.equals(""))
                {
                    Toast.makeText(MainActivity2.this,
                            "Nom obligatoire", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Anciennes versions
               // File file = new File("/sdcard/",fname+".txt");

                //Versions nouvelles
                //Espace interne
              /*  File file=new File(getFilesDir(),fname+".txt");
                IOFile iofile =new IOFile();
                iofile.writeFile(file,contenu);
                Toast.makeText(MainActivity2.this,
                        "fichier crée", Toast.LENGTH_SHORT).show();*/

                //Espace externe
               // File file=new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),fname+".txt");
                /*File file=new
                        File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),fname+".txt");*/
               File file2= new
                        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                        fname+".txt");
                IOFile iofile =new IOFile();
                iofile.writeFile(file2,contenu);
                Toast.makeText(MainActivity2.this,
                        "fichier crée", Toast.LENGTH_SHORT).show();

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname= edittextfiletoread.getText().toString();
                String contenu= "";
                IOFile iofile =new IOFile();
              /*  File file=new File(getFilesDir(),fname+".txt");
               contenu = iofile.readFile(file);
               textviewread.setText(contenu);*/

               /* File file=new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),fname+".txt");
               */
                File file2= new
                        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                        fname+".txt");
                contenu = iofile.readFile(file2);
                textviewread.setText(contenu);

            }
        });
    }
}