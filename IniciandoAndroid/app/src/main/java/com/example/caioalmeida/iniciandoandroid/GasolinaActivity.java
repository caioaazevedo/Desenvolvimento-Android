package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GasolinaActivity extends Activity {

    TextView textView;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasolina);

        textView = findViewById(R.id.textGas);
        imageView = findViewById(R.id.imageGas);

        String msg = "MELHOR ABASTECER COM GASOLINA!";

        textView.setText(msg);

        imageView.setImageResource(R.drawable.gasolina);
    }
}
