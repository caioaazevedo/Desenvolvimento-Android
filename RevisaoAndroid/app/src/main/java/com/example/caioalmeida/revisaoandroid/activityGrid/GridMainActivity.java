package com.example.caioalmeida.revisaoandroid.activityGrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.caioalmeida.revisaoandroid.R;
import com.example.caioalmeida.revisaoandroid.activityInfo.InfoCarroActivity;
import com.example.caioalmeida.revisaoandroid.adapter.listAdapter;
import com.example.caioalmeida.revisaoandroid.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class GridMainActivity extends Activity implements AdapterView.OnItemClickListener{

    GridView gridView;
    List<Carro> carros_list;
    listAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_main);

        gridView = findViewById(R.id.gridObjs);

        carros_list = new ArrayList<>();
        carros_list.add(new Carro("Onix", "Chevrolet", "2018", R.drawable.onix));
        carros_list.add(new Carro("Corolla", "Toyota", "2017", R.drawable.corolla));
        carros_list.add(new Carro("Gol", "Volkwagen", "2018", R.drawable.gol));
        carros_list.add(new Carro("Palio", "Fiat", "2018", R.drawable.palio));
        carros_list.add(new Carro("Sentra", "Nissan", "2018", R.drawable.sentra));
        carros_list.add(new Carro("Z4", "Bmw", "2014", R.drawable.z4));

        adapter = new listAdapter(this, carros_list);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, InfoCarroActivity.class);
        intent.putExtra("Obj", carros_list.get(position));
        intent.putExtra("Frase", "Olá, Mundo!");
        startActivity(intent);
    }
}
