package com.example.caioalmeida.listviewpersonalizada.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.caioalmeida.listviewpersonalizada.R;
import com.example.caioalmeida.listviewpersonalizada.adapter.AdapterCarro;
import com.example.caioalmeida.listviewpersonalizada.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView listView;
    AdapterCarro adapterCarro;
    List<Carro> list_carro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_carro = new ArrayList<>();
        list_carro.add(new Carro("Chevrolet", "Onix", "2018", R.drawable.onix));
        list_carro.add(new Carro("Fiat", "Palio", "2016", R.drawable.palio));
        list_carro.add(new Carro("Toyota", "Corolla", "2017", R.drawable.corolla));
        list_carro.add(new Carro("Nissan", "Sentra", "2018", R.drawable.sentra));
        list_carro.add(new Carro("Volkswagen", "Gol", "2017", R.drawable.gol));
        list_carro.add(new Carro("Bmw", "Z4", "2014", R.drawable.z4));

        adapterCarro = new AdapterCarro(this, list_carro);

        listView = findViewById(R.id.listViewCarros);

        listView.setAdapter(adapterCarro);
    }
}
