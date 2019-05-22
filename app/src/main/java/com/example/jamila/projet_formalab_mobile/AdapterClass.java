package com.example.jamila.projet_formalab_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterClass extends ArrayAdapter<Project> {
    Context ctx;

    public AdapterClass( Context context, List<Project> objects) {
        super(context, R.layout.model, objects);
        this.ctx=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(ctx).inflate(R.layout.model,parent,false);

        TextView title = convertView.findViewById(R.id.txt_title);

        Project projet=getItem(position);
        title.setText(projet.getTitre());

        return convertView;
    }

}

