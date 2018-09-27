package com.example.caioalmeida.requisicaovolley;

import android.app.Activity;
import android.app.VoiceInteractor;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText editText;
    TextView textViewDolar;
    Button button;

    String URL = "https://economia.awesomeapi.com.br/all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editValor);
        textViewDolar = findViewById(R.id.textDolar);
        button = findViewById(R.id.buttonConverter);

        button.setOnClickListener(this);
    }

    private void obterCotacao(final double valor) {
        RequestQueue req = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject moeda = response.getJSONObject("USD");
                            double cotacao = moeda.getDouble("bid");
                            double conversao = cotacao * valor;
                            textViewDolar.setText(String.format("R$ %.2f", conversao));

                        } catch (JSONException e) {
                            textViewDolar.setText("Erro de Exceção!");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textViewDolar.setText("Erro de Requisição");
                error.printStackTrace();
            }
        });

        req.add(request);
    }

    @Override
    public void onClick(View v) {
        String valorTexto;
        try {
            valorTexto = editText.getText().toString();
            final double valor = Double.parseDouble(valorTexto);
            obterCotacao(valor);
        } catch (RuntimeException e){
            textViewDolar.setText("Valor Nulo!");
            e.printStackTrace();
        }
    }
}
