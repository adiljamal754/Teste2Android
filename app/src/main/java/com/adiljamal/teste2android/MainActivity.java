package com.adiljamal.teste2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.adiljamal.teste2android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;



   private static DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        dbHelper = new DBHelper(this);

        //click do botão save
        mainBinding.saveBtn.setOnClickListener( v -> {
            save();
        });

        //click do botão listar
        mainBinding.listBtn.setOnClickListener( v -> {
            Intent it = new Intent(this, ListaActivity.class);
            startActivity(it);
        });
    }

    private void save() {
        if (dbHelper.save(
                mainBinding.nameET.getText().toString(),
                mainBinding.sexoET.getText().toString(),
                mainBinding.moradaET.getText().toString(),
                mainBinding.telefoneET.getText().toString()
        ) == 1){
            Toast.makeText(this, "Gravado com sucesso", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Erro ao salvar", Toast.LENGTH_LONG).show();
        }
    }
}