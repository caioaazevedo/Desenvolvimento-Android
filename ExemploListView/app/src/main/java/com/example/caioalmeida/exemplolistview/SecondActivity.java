package com.example.caioalmeida.exemplolistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.txtView);
        textView2 = findViewById(R.id.txtView2);
        textView3 = findViewById(R.id.txtView3);

        imageView = findViewById(R.id.image);

        Carro carro = (Carro) getIntent().getSerializableExtra("objCarro");

        int id = getIntent().getIntExtra("id", 0);

        textView.setText(carro.getFabricante());
        textView2.setText(carro.getModelo());
        textView3.setText(carro.getAno());

        switch (id){
            case 0:
                imageView.setImageResource(R.drawable.fiat_palio);
                break;
            case 1:
                imageView.setImageResource(R.drawable.volkswagen_gol);
                break;
            case 2:
                imageView.setImageResource(R.drawable.bmw_z4);
                break;
        }
    }
}
