package com.example.caioalmeida.gridviewcompartilhamento;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

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
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:46.7170627,-71.2884537"));
                break;
            case 1:
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_TEXT, "Texto para ser enviado");
                intent.setType("text/plain");
                break;
            case 2:
                String number = "77777777";
                Uri uri = Uri.parse("tel:" + number);
                intent = new Intent(Intent.ACTION_CALL, uri);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ucb.br/"));
                break;
        }

        startActivity(intent);
    }
}

