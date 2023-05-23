package com.adiljamal.teste2android;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "AlunoDB";
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "alunos";
    private static final String _ID = "id";
    private static final String _NOME = "nome";
    private static final String _SEXO = "sexo";
    private static final String _MORADA = "morada";
    private static final String _TELEFONE = "telefone";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " ( " + _ID + " " +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + _NOME + " TEXT NOT NULL, "
            + _SEXO + " TEXT, " + _MORADA + " TEXT, " + _TELEFONE + " TEXT );";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public long save(String nome,String sexo,String morada,String telefone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(_NOME, nome);
        value.put(_SEXO, sexo);
        value.put(_MORADA, morada);
        value.put(_TELEFONE, telefone);
        long insert = db.insert(TABLE_NAME, null, value);
        db.close();
        return insert;
    }

    @SuppressLint("Range")
    public  ArrayList<Estudante> getAll() {
        ArrayList<Estudante> estudantes = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Estudante estudante = new Estudante();
                estudante.setId(cursor.getInt(cursor.getColumnIndex(_ID)));
                estudante.setNome(cursor.getString(cursor.getColumnIndex(_NOME)));
                estudante.setSexo(cursor.getString(cursor.getColumnIndex(_NOME)));
                estudante.setMorada(cursor.getString(cursor.getColumnIndex(_NOME)));
                estudante.setTelfone(cursor.getString(cursor.getColumnIndex(_NOME)));

                estudantes.add(estudante);

            } while (cursor.moveToNext());

            cursor.close();
            db.close();

        }
        return estudantes;
    }
}
