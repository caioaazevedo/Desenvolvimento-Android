package com.example.caioalmeida.revisaoandroid.adapter;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caioalmeida.revisaoandroid.R;
import com.example.caioalmeida.revisaoandroid.model.Carro;

import java.util.List;

public class listAdapter extends BaseAdapter{
    public listAdapter(Activity activity, List<Carro> carros) {
        this.activity = activity;
        this.carros = carros;
    }

    private Activity activity;
    private List<Carro> carros;

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Carro carro = carros.get(position);

        convertView = View.inflate(activity, R.layout.list_carro_layout, null);

        ImageView image = convertView.findViewById(R.id.imageCarro);
        TextView modelo = convertView.findViewById(R.id.textModelo);
        TextView fabricante = convertView.findViewById(R.id.textFabricante);
        TextView ano = convertView.findViewById(R.id.textAno);

        image.setImageResource(carro.getImagem());
        modelo.setText(carro.getModelo());
        fabricante.setText(carro.getFabricante());
        ano.setText(carro.getAno());

        return convertView;
    }
}
