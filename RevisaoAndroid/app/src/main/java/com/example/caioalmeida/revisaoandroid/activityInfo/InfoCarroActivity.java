package com.example.caioalmeida.revisaoandroid.activityInfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caioalmeida.revisaoandroid.R;
import com.example.caioalmeida.revisaoandroid.model.Carro;

public class InfoCarroActivity extends Activity {

    ImageView imageView;
    TextView textModelo;
    TextView textFabricante;
    TextView textAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_carro);

        imageView = findViewById(R.id.imageCarroInfo);
        textModelo = findViewById(R.id.textModeloInfo);
        textFabricante = findViewById(R.id.textFabricanteInfo);
        textAno = findViewById(R.id.textAnoInfo);

        Carro carro = (Carro) getIntent().getSerializableExtra("Obj");

        imageView.setImageResource(carro.getImagem());
        textModelo.setText(carro.getModelo());
        textFabricante.setText(carro.getFabricante());
        textAno.setText(carro.getAno());

    }
}
