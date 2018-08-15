package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CombustivelActivity extends Activity implements View.OnClickListener{

    Button btn;

    EditText txt1;
    EditText txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        btn = findViewById(R.id.btnCalculaCombustivel);
        btn.setOnClickListener(this);

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
            Toast.makeText(this, "Melhor abastecer com Gasolina", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Melhor abastecer com Álcool", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        showResult();
    }
}
