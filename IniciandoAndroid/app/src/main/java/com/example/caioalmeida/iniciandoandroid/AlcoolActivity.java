package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AlcoolActivity extends Activity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool);

        textView = findViewById(R.id.textAlcool);
        imageView = findViewById(R.id.imageAlcool);

        String msg = "MELHOR ABASTECER COM ÁLCOOL!";

        textView.setText(msg);

        imageView.setImageResource(R.drawable.alcool);
    }
}
