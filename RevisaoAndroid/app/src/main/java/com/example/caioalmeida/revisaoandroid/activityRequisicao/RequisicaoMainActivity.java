package com.example.caioalmeida.revisaoandroid.activityRequisicao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.caioalmeida.revisaoandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class RequisicaoMainActivity extends Activity implements View.OnClickListener{

    EditText editText;
    Button button;
    TextView textView;

    String url = "https://api.myjson.com/bins/wqn1k";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisicao_main);

        editText = findViewById(R.id.editReqPesquisa);
        button = findViewById(R.id.buttonReqPesquisa);
        textView = findViewById(R.id.textReqInformacoes);



        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String text = editText.getText().toString();
        obterRequisicao(text);
    }

    private void obterRequisicao(final String texto) {
        RequestQueue res = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("estudantes");

                            boolean existe = false;

                            for(int i = 0; i < jsonArray.length(); i++) {
                                JSONObject estudantes = jsonArray.getJSONObject(i);

                                if(estudantes.getString("matricula").equals(texto)){
                                    String matriculaEstudante = estudantes.getString("matricula");
                                    String nome = estudantes.getString("nome");
                                    int idade = estudantes.getInt("idade");
                                    String curso = estudantes.getString("curso");

                                    textView.setText(" Matrícula: " + matriculaEstudante + "\n" +
                                            " Nome: " + nome + "\n Idade: " + String.valueOf(idade) +
                                            "\n Curso: " + curso);
                                    existe = true;
                                }
                            }

                            if(!existe){
                                textView.setText("ERROR! Estudante não exite!");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            textView.setText("ERROR! Estudante não exite!");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Requisição ERROR!");
            }
        });

        res.add(request);
    }
}
