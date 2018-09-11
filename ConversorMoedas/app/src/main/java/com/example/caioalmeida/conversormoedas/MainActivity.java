package com.example.caioalmeida.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewHolder mViewHolder = new ViewHolder();

    double valueDollarQuotation = 4.06;
    double valueEuroQuotation = 4.70;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.editValue);
        this.mViewHolder.textDollar = findViewById(R.id.textDollar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.textValueDollar = findViewById(R.id.textValorDolar);
        this.mViewHolder.textValueEuro = findViewById(R.id.textValorEuro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.buttonCalculate);

        String stringValueDolar = String.valueOf(valueDollarQuotation);
        String stringValueEuro = String.valueOf(valueEuroQuotation);

        this.mViewHolder.textValueDollar.setText("Dolar: $ " + stringValueDolar);
        this.mViewHolder.textValueEuro.setText("Euro: € " + stringValueEuro);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
        this.mViewHolder.textDollar.setText(" $ " + String.format("%.2f", value / valueDollarQuotation));
        this.mViewHolder.textEuro.setText(" € " + String.format("%.2f", value / valueEuroQuotation));
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        TextView textValueDollar;
        TextView textValueEuro;
        Button buttonCalculate;

    }
}
