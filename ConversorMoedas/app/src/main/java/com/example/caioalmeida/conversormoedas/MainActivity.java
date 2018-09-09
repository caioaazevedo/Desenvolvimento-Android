package com.example.caioalmeida.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.editValue);
        this.mViewHolder.textDolar = findViewById(R.id.textDolar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.buttonCalculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
        this.mViewHolder.textDolar.setText(" $ " + String.format("%.2f", value / 4.06));
        this.mViewHolder.textEuro.setText(" € " + String.format("%.2f", value / 4.70));
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;

    }
}
