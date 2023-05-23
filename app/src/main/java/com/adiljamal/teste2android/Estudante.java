package com.adiljamal.teste2android;

public class Estudante {

    private int id;
    private String nome;
    private String sexo;
    private String morada;
    private String telfone;

    public Estudante(){}
    public Estudante(String nome, String sexo, String morada, String telfone) {
        this.nome = nome;
        this.sexo = sexo;
        this.morada = morada;
        this.telfone = telfone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelfone() {
        return telfone;
    }

    public void setTelfone(String telfone) {
        this.telfone = telfone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
