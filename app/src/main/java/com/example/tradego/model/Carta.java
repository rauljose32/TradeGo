package com.example.tradego.model;

public class Carta {

    private int estrelas;
    private String atributo;
    private String tipo;
    private int ataque;
    private int defesa;
    private String nome;

    public Carta() {
    }

    public Carta(int estrelas, String atributo, String tipo, int ataque, int defesa, String nome) {
        this.estrelas = estrelas;
        this.atributo = atributo;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nome = nome;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return
                "Nome " + nome +
                        ", Nivel " + estrelas +
                        ", Atributo " + atributo +
                        ", Tipo " + tipo +
                        "\n";
    }
}
