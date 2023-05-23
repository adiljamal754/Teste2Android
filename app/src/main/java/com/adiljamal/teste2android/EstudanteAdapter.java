package com.adiljamal.teste2android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EstudanteAdapter extends BaseAdapter {

    ArrayList<Estudante> estudantes = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public EstudanteAdapter(Context context, ArrayList<Estudante> estudantes ) {
        this.estudantes = estudantes;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return estudantes.size();
    }

    @Override
    public Object getItem(int position) {
        return estudantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_item, null);
        TextView nomeTV = convertView.findViewById(R.id.nomeTV);
        nomeTV.setText(estudantes.get(position).getNome());

        return convertView;
    }
}
