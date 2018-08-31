package com.example.caioalmeida.exemplolistview;

import java.io.Serializable;

public class Carro implements Serializable{
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    private String fabricante;
    private String modelo;
    private int ano;
}
