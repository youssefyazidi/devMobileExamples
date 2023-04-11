package com.example.activite6_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.activite6_2.R;

import java.util.List;

public class MonAdapter extends BaseAdapter {

    private Context context;
    private List<Logiciel> data;

    //Le contexte + données
    public MonAdapter(Context ctx, List<Logiciel> data) {
        this.context = ctx;
        this.data=data;
    }

    //Obligatoire
    @Override
    public int getCount() {
        return data.size();
    }


    //Obligatoire
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View mavue=view;

        if(mavue == null)
        {
         //recuperer une reference Inflater
            //Inflate = dessiner le xml en java
           LayoutInflater
                   inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              mavue=inflater.inflate(R.layout.liste_element,null);

            ImageView image=mavue.findViewById(R.id.imageView1);
            TextView txtnom =mavue.findViewById(R.id.textnom);
            TextView txtdesc =mavue.findViewById(R.id.textdesc);
            image.setImageResource(data.get(i).getResImage());
            txtnom.setText(data.get(i).getNom());
            txtdesc.setText(data.get(i).getDesc());
        }

        return mavue;
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
