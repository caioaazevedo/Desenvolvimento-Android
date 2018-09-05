package com.example.caioalmeida.exemplolistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.arrayCarros));

        listView = findViewById(R.id.lista);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent( MainActivity.this, CarrosInfoActivity.class);

        Carro carro0 = new Carro();
        carro0.setFabricante("FIAT");
        carro0.setModelo("Palio");
        carro0.setAno("2017");
        carro0.setImagem(R.drawable.fiat_palio);

        Carro carro1 = new Carro();
        carro1.setFabricante("VOLKSWAGEN");
        carro1.setModelo("Gol");
        carro1.setAno("2018");
        carro1.setImagem(R.drawable.volkswagen_gol);

        Carro carro2 = new Carro();
        carro2.setFabricante("BMW");
        carro2.setModelo("z4");
        carro2.setAno("2015");
        carro2.setImagem(R.drawable.bmw_z4);

        switch(i) {
            case 0:
                intent.putExtra("objCarro", carro0);
                break;
            case 1:
                intent.putExtra("objCarro", carro1);
                break;
            case 2:
                intent.putExtra("objCarro", carro2);
                break;
        }

        intent.putExtra("id", i);

        startActivity(intent);
        Toast.makeText(this, "Item acionado", Toast.LENGTH_LONG).show();
    }
}
