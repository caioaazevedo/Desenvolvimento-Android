package com.example.caioalmeida.gridviewcompartilhamento;

import android.app.Activity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    GridView gridView;
    imageAdapter adapterImage;
    List<Imagem> list_imagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridviewShare);

        list_imagens = new ArrayList<>();
        list_imagens.add(new Imagem(R.drawable.mapa));
        list_imagens.add(new Imagem(R.drawable.texto));
        list_imagens.add(new Imagem(R.drawable.ligacao));
        list_imagens.add(new Imagem(R.drawable.ucb));


        adapterImage = new imageAdapter(this, list_imagens);

        gridView.setAdapter(adapterImage);
    }
}

