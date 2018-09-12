package com.example.caioalmeida.exemplogridview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caioalmeida.exemplogridview.R;
import com.example.caioalmeida.exemplogridview.model.Carro;

public class InfoCarroActivity extends Activity {

    TextView textViewModelo;
    TextView textViewFabricante;
    TextView textViewAno;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_carro);

        textViewModelo = findViewById(R.id.textInfoModelo);
        textViewFabricante = findViewById(R.id.textInfoFabricante);
        textViewAno = findViewById(R.id.textInfoAno);

        imageView = findViewById(R.id.imageInfoCarro);

        Carro carro = (Carro) getIntent().getSerializableExtra("objCarro");

        textViewModelo.setText(carro.getModelo());
        textViewFabricante.setText(carro.getFabricante());
        textViewAno.setText(carro.getAno());
        imageView.setImageResource(carro.getImagem());
    }
}
