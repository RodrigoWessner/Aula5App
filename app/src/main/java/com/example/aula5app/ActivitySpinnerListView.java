package com.example.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class ActivitySpinnerListView extends AppCompatActivity {
    String [] Estado = {"Paraná", "Bahia","Acre"};
    String [] CidadesParana = {"Cascavel", "Curitiba", "Londrina"};
    String [] CidadesBahia = {"Ilheus", "Salvador", "Barreiras"};
    String [] CidadesAcre = {"Rio Branco", "Epitaciolândia", "Acrelândia"};
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_list_view);

        Spinner categoria = (Spinner) findViewById(R.id.uf);
        ListView cidades = (ListView) findViewById(R.id.list_view);
        TextView nometxt = (TextView) findViewById(R.id.nometxt);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        nometxt.setText(nome.toString());

        //adapter cidades
        ArrayAdapter adapterCidades = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,Arrays.asList(CidadesParana));
        cidades.setAdapter(adapterCidades);


        //Adapter Estado
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Estado);
        categoria.setAdapter(adapter);


        categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selected = Estado[position];
                Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}