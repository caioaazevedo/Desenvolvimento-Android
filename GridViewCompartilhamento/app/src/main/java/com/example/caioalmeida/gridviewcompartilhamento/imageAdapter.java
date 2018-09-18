package com.example.caioalmeida.gridviewcompartilhamento;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;


public class imageAdapter extends BaseAdapter{

    public imageAdapter(Activity activity, List<Imagem> imagem) {
        this.activity = activity;
        this.imagem = imagem;
    }

    private Activity activity;
    private List<Imagem> imagem;


    @Override
    public int getCount() {
        return imagem.size();
    }

    @Override
    public Object getItem(int position) {
        return imagem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Imagem img = imagem.get(position);

        convertView = View.inflate(activity, R.layout.layout_list_image, null);

        ImageView imageView = convertView.findViewById(R.id.imageFuncionalidades);

        imageView.setImageResource(img.getImagens());

        return convertView;
    }
}
