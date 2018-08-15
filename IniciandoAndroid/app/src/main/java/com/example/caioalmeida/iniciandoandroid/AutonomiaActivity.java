package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AutonomiaActivity extends Activity implements View.OnClickListener{

    Button btn;

    EditText editKm;
    EditText editLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomia);

        btn = findViewById(R.id.btnCalculaAutonomia);
        btn.setOnClickListener(this);
    }


    public double obtemCalculo(){
        editKm = findViewById(R.id.edtKm);
        editLitros = findViewById(R.id.edtLitros);
        String txt = editKm.getText().toString();
        String txt2 = editLitros.getText().toString();
        double km = Double.parseDouble(txt);
        double litros = Double.parseDouble(txt2);

        double result = km/litros;

        return result;
    }



    @Override
    public void onClick(View view) {
        double num = obtemCalculo();
        String msg = String.valueOf(num);
        String txtMsg = msg+" Km/L";

        Toast.makeText(this, txtMsg, Toast.LENGTH_LONG).show();
    }
}
