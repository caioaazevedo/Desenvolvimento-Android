package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CombustivelActivity extends Activity implements View.OnClickListener{

    Button btn;

    EditText txt1;
    EditText txt2;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        btn = findViewById(R.id.btnCalculaCombustivel);
        btn.setOnClickListener(this);

        imageView = findViewById(R.id.imageCombustivel);

        imageView.setImageResource(R.drawable.combustivel);
    }

    public double obtemCalculo(){
        txt1 = findViewById(R.id.edtGas);
        txt2 = findViewById(R.id.edtAlcool);
        String txt = txt1.getText().toString();
        String txtDois = txt2.getText().toString();
        double gas = Double.parseDouble(txt);
        double alcool = Double.parseDouble(txtDois);

        double result = alcool/gas;

        return result;
    }

    public void showResult(){
        if(obtemCalculo() >= 0.7){
            Intent intentGas = new Intent(CombustivelActivity.this, GasolinaActivity.class);
            startActivity(intentGas);
            //Toast.makeText(this, "Melhor abastecer com Gasolina", Toast.LENGTH_LONG).show();
        } else {
            Intent intentAlcool = new Intent(CombustivelActivity.this, AlcoolActivity.class);
            startActivity(intentAlcool);
            //Toast.makeText(this, "Melhor abastecer com Álcool", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        showResult();
    }
}
