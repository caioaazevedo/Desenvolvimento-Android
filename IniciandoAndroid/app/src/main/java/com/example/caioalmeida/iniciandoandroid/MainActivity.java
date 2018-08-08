package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    Button button;

    EditText text1;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnCalcula);
        button.setOnClickListener(this);
    }

    public double obtemCalculo(){
        text1 = findViewById(R.id.edtTexto1);
        text2 = findViewById(R.id.edtTexto2);
        String txt = text1.getText().toString();
        String txt2 = text2.getText().toString();
        double gas = Double.parseDouble(txt);
        double alcool = Double.parseDouble(txt2);

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
