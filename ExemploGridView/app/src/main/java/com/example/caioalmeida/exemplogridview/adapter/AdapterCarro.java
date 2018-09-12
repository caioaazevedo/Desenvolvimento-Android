package com.example.caioalmeida.exemplogridview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caioalmeida.exemplogridview.R;
import com.example.caioalmeida.exemplogridview.model.Carro;

import java.util.List;

public class AdapterCarro extends BaseAdapter {
    public AdapterCarro(Activity activity, List<Carro> carrosList) {
        this.activity = activity;
        this.carrosList = carrosList;
    }

    private Activity activity;
    private List<Carro> carrosList;

    @Override
    public int getCount() {
        return carrosList.size();
    }

    @Override
    public Object getItem(int position) {
        return carrosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Carro carro = carrosList.get(position);

        convertView = View.inflate(activity, R.layout.layout_list_carro, null);

        //LayoutInflater inflater = activity.getLayoutInflater();

        //convertView = inflater.inflate(R.layout.layout_list_carro, parent, false);


        TextView modelo = convertView.findViewById(R.id.textModelo);
        TextView fabricante = convertView.findViewById(R.id.textFabricante);
        TextView ano = convertView.findViewById(R.id.textAno);
        ImageView imagem = convertView.findViewById(R.id.imageCarro);

        modelo.setText(carro.getModelo());
        fabricante.setText(carro.getFabricante());
        ano.setText(carro.getAno());
        imagem.setImageResource(carro.getImagem());

        return convertView;
    }
}
