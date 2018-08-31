package com.example.caioalmeida.passagemparametro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends Activity {

    TextView txtView;
    TextView txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtView = findViewById(R.id.tView);
        txtView2 = findViewById(R.id.tView2);

        String nome = getIntent().getStringExtra("nome");

        //necessario identificar qual objeto que eu quero pegar atravez do ==> Cast
        Carro carro = (Carro) getIntent().getSerializableExtra("objCarro");

        txtView.setText(nome);
        txtView2.setText(carro.getFabricante());
    }
}
