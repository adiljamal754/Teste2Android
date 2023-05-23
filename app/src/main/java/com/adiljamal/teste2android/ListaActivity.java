package com.adiljamal.teste2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adiljamal.teste2android.databinding.ActivityListaBinding;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

   private ArrayList<Estudante> estudantes;
   private DBHelper dbhelper;
   private ActivityListaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbhelper = new DBHelper(this);

        estudantes = dbhelper.getAll();

        EstudanteAdapter adapter = new EstudanteAdapter(this, estudantes);

        for (Estudante e: estudantes
             ) {
            System.out.println(e.getNome());
        }

        binding.estudantesLV.setAdapter(adapter);


    }
}