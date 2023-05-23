package com.example.sqliteexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.sqliteexample.R;
import com.example.sqliteexample.data.Produit;

import java.util.ArrayList;

public class ProduitAdapter extends BaseAdapter {

    private ArrayList<Produit> liste;
    private Context ctx;

    public ProduitAdapter(@NonNull Context context,
                          @NonNull ArrayList<Produit> liste)
    {
        this.liste=liste;
        this.ctx=context;
    }


    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Produit pro=liste.get(i);
        if(view==null) {
            LayoutInflater inflater =
                    (LayoutInflater)
                            ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
        }

        TextView code = (TextView) view.findViewById(R.id.code_l);
        TextView desc = (TextView) view.findViewById(R.id.description_l);
        TextView prix = (TextView) view.findViewById(R.id.prix_l);

        code.setText(String.valueOf(pro.getCode()));
        desc.setText(pro.getDescription());
        prix.setText(String.valueOf(pro.getPrix()));

        return  view;
    }
}
