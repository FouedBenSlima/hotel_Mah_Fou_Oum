package com.example.hadidi.hotel_mah_fou_oum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChmbreAdap extends ArrayAdapter {
    Context adapterContext;
    int adapterRessource;
    ArrayList<Chambre> adapterEtudient;

    public ChmbreAdap(@NonNull Context context, int resource, ArrayList<Chambre> etudient_data) {
        super(context, resource, etudient_data);
        adapterContext = context;
        adapterRessource = resource;
        adapterEtudient = etudient_data;


    }

    @Nullable
    @Override
    public Object getItem(int position) {

        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater rowinflater = LayoutInflater.from(adapterContext);
        row = rowinflater.inflate(adapterRessource, parent, false);
        TextView id = row.findViewById(R.id.id);
        TextView name = row.findViewById(R.id.nom);
        ImageView img = row.findViewById(R.id.i1);

        // id.setText(Integer.valueOf(adapterEtudient.get(i).getCin()).toString());
        id.setText(adapterEtudient.get(i).getNomcl());
        name.setText(adapterEtudient.get(i).getNumchabre());


        return row;

    }
}
