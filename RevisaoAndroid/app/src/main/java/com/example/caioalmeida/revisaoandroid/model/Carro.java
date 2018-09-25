package com.example.caioalmeida.revisaoandroid.model;

public class Carro {

    private String modelo;
    private String fabricante;
    private String ano;
    private int imagem;

    public Carro(String modelo, String fabricante, String ano, int imagem) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
