package com.example.caioalmeida.exemplogridview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.caioalmeida.exemplogridview.R;
import com.example.caioalmeida.exemplogridview.adapter.AdapterCarro;
import com.example.caioalmeida.exemplogridview.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    List<Carro> list_carro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);

        list_carro = new ArrayList<>();
        list_carro.add(new Carro("Onix",  "Chevrolet", "2018", R.drawable.onix));
        list_carro.add(new Carro("Palio", "Fiat", "2016", R.drawable.palio));
        list_carro.add(new Carro("Corolla", "Toyota", "2017", R.drawable.corolla));
        list_carro.add(new Carro("Sentra", "Nissan", "2018", R.drawable.sentra));
        list_carro.add(new Carro("Gol", "Volkswagen", "2017", R.drawable.gol));
        list_carro.add(new Carro("Z4", "Bmw", "2014", R.drawable.z4));

        AdapterCarro adapterCarro = new AdapterCarro(this, list_carro);

        gridView.setAdapter(adapterCarro);
    }
}
