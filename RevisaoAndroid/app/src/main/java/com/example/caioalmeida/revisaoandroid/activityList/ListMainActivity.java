package com.example.caioalmeida.revisaoandroid.activityList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.caioalmeida.revisaoandroid.R;
import com.example.caioalmeida.revisaoandroid.adapter.listAdapter;
import com.example.caioalmeida.revisaoandroid.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class ListMainActivity extends Activity implements AdapterView.OnItemClickListener{

    ListView listView;
    List<Carro> list_carro;
    listAdapter adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

        listView = findViewById(R.id.listObjs);

        list_carro = new ArrayList<>();
        list_carro.add(new Carro("Onix", "Chevrolet", "2018", R.drawable.onix));
        list_carro.add(new Carro("Corolla", "Toyota", "2017", R.drawable.corolla));
        list_carro.add(new Carro("Gol", "Volkwagen", "2018", R.drawable.gol));
        list_carro.add(new Carro("Palio", "Fiat", "2018", R.drawable.palio));
        list_carro.add(new Carro("Sentra", "Nissan", "2018", R.drawable.sentra));
        list_carro.add(new Carro("Z4", "Bmw", "2014", R.drawable.z4));

        adapterList = new listAdapter(this, list_carro);

        listView.setAdapter(adapterList);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
