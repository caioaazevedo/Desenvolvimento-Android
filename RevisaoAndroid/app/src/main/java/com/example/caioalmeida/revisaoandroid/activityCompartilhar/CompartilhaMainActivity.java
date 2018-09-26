package com.example.caioalmeida.revisaoandroid.activityCompartilhar;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import com.example.caioalmeida.revisaoandroid.R;
import com.example.caioalmeida.revisaoandroid.adapter.listAdapter;

public class CompartilhaMainActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener{

    ListView listView;
    ArrayAdapter arrayAdapter;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartilha_main);

        listView = findViewById(R.id.listCompartilha);
        editText = findViewById(R.id.editCompartilha);
        button = findViewById(R.id.buttonBuscar);


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.arrayStrings));

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);
        button.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 77777777"));
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/caioaazevedo"));
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.putExtra(Intent.EXTRA_TEXT, "Olá Mundo!");
                intent2.setType("text/plain");
                startActivity(intent2);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        String text = editText.getText().toString();
        Intent intent3 = new Intent(Intent.ACTION_WEB_SEARCH);
        intent3.putExtra(SearchManager.QUERY, text);
        startActivity(intent3);
    }
}
