package com.example.caioalmeida.exemplolistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarrosInfoActivity extends Activity {

    TextView textView1;
    TextView textView2;
    TextView textView3;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_info);

        textView1 = findViewById(R.id.textFabricante);
        textView2 = findViewById(R.id.textModelo);
        textView3 = findViewById(R.id.textAno);
        imageView = findViewById(R.id.imageCarro);

        Carro carro = (Carro) getIntent().getSerializableExtra("objCarro");

        textView1.setText(carro.getFabricante());
        textView2.setText(carro.getModelo());
        textView3.setText(carro.getAno());
        imageView.setImageResource(carro.getImagem());
    }
}
