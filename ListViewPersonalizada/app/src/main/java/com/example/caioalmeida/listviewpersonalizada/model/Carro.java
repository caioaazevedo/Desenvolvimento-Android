package com.example.caioalmeida.listviewpersonalizada.model;

public class Carro {
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public Carro(String fabricante, String modelo, String ano, int imagem) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ano = ano;
        this.imagem = imagem;
    }

    private String fabricante;
    private String modelo;
    private String ano;
    private int imagem;
}
