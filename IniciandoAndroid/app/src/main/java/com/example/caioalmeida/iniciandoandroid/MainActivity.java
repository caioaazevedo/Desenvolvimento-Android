package com.example.caioalmeida.iniciandoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnCombustivel);
        button.setOnClickListener(this);
        button2 = findViewById(R.id.btnAutonomia);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnCombustivel:
                Intent intent = new Intent(MainActivity.this, CombustivelActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAutonomia:
                Intent intent2 = new Intent(MainActivity.this, AutonomiaActivity.class);
                startActivity(intent2);
                break;

        }
    }
}
