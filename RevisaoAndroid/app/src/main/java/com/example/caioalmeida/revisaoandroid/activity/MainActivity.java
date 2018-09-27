package com.example.caioalmeida.revisaoandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.caioalmeida.revisaoandroid.R;
import com.example.caioalmeida.revisaoandroid.activityCompartilhar.CompartilhaMainActivity;
import com.example.caioalmeida.revisaoandroid.activityGrid.GridMainActivity;
import com.example.caioalmeida.revisaoandroid.activityList.ListMainActivity;
import com.example.caioalmeida.revisaoandroid.activityRequisicao.RequisicaoMainActivity;

public class MainActivity extends Activity  implements View.OnClickListener {

    Button buttonList;
    Button buttonGrid;
    Button buttonCompartilha;
    Button buttonRequisicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonList = findViewById(R.id.buttonList);
        buttonList.setOnClickListener(this);

        buttonGrid = findViewById(R.id.buttonGrid);
        buttonGrid.setOnClickListener(this);

        buttonCompartilha = findViewById(R.id.buttonCompartilha);
        buttonCompartilha.setOnClickListener(this);

        buttonRequisicao = findViewById(R.id.buttonRequisicao);
        buttonRequisicao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonList:
                Intent intentList = new Intent(MainActivity.this, ListMainActivity.class);
                startActivity(intentList);
                break;
            case R.id.buttonGrid:
                Intent intentGrid = new Intent(MainActivity.this, GridMainActivity.class);
                startActivity(intentGrid);
                break;
            case R.id.buttonCompartilha:
                Intent intentComp = new Intent(MainActivity.this, CompartilhaMainActivity.class);
                startActivity(intentComp);
                break;
            case R.id.buttonRequisicao:
                Intent intentReq = new Intent(MainActivity.this, RequisicaoMainActivity.class);
                startActivity(intentReq);
        }
    }
}
