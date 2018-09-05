package com.example.caioalmeida.listviewpersonalizada.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caioalmeida.listviewpersonalizada.R;
import com.example.caioalmeida.listviewpersonalizada.model.Carro;

import java.util.List;

public class AdapterCarro extends BaseAdapter {

    public AdapterCarro(Activity activity, List<Carro> carros){
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
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Carro carro = carros.get(i);

        view = View.inflate(activity, R.layout.layout_list_carro, null);

        TextView fabricante = view.findViewById(R.id.textFabricante);
        TextView modelo = view.findViewById(R.id.textModelo);
        TextView ano = view.findViewById(R.id.textAno);
        ImageView imagem = view.findViewById(R.id.imageCarro);

        fabricante.setText(carro.getFabricante());
        modelo.setText(carro.getModelo());
        ano.setText(carro.getAno());
        imagem.setImageResource(carro.getImagem());


        return view;
    }
}
