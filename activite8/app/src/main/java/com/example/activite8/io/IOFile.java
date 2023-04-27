package com.example.activite8.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOFile {


    public boolean writeFile(File file, String contenu)
    {
        //ancienne = acces à l'espace interne
        //String path="/sdcard/"+fname+".txt";
        //Utilisation de la classe File
        //Le type File = encpsuler un fichier ou un repertoire
        //il va permettre d'executer toutes les opérations OS
       // File file=new File(path);
        try {
            if(!file.exists()) {

                file.createNewFile();
            }
//l'operation d'ecriture
            //ouverture de fichier en mode write
            FileWriter fw=new FileWriter(file);
            fw.write(contenu);
            fw.close();
            return true;
            } catch (IOException e) {
                e.printStackTrace();
            return false;
            }
    }


    public String readFile(File file)
    {
     StringBuffer buffer=new StringBuffer("");
        try{

            //l'operation d'ecriture
            //ouverture de fichier en mode read
           BufferedReader bf=
                   new BufferedReader(new FileReader(file));
           //Lire une ligne  complete (null a la fin de fichier)
          String ligne = bf.readLine();
          while(ligne!=null)
          {
              buffer.append(ligne);
              ligne=bf.readLine();
          }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
