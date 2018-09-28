package com.example.caioalmeida.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String url = "https://economia.awesomeapi.com.br/all";

    EditText editValue;
    TextView textDollar;
    TextView textEuro;
    TextView textValueDollar;
    TextView textValueEuro;
    Button buttonCalculate;

    double valueDollarQuotation = 4.06;
    double valueEuroQuotation = 4.70;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValue);
        textDollar = findViewById(R.id.textDollar);
        textEuro = findViewById(R.id.textEuro);
        textValueDollar = findViewById(R.id.textValorDolar);
        textValueEuro = findViewById(R.id.textValorEuro);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        obterCotacao(0.0);

        String stringValueEuro = String.valueOf(valueEuroQuotation);

        textValueEuro.setText("Euro: € " + stringValueEuro);

        buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Double value = Double.valueOf(editValue.getText().toString());
        obterCotacao(value);
        textEuro.setText(" € " + String.format("%.2f", value / valueEuroQuotation));
    }

    private void obterCotacao(final double valor) {
        RequestQueue req = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject cotacao = response.getJSONObject("USD");
                            double valorDolar = cotacao.getDouble("bid");
                            textValueDollar.setText(String.format(" Dolar: $ %.2f", valorDolar));
                            if (valor != 0.0) {
                                textDollar.setText(" $ " + String.format("%.2f", valor / valorDolar));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        req.add(request);
    }
}
