package com.example.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ListaActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listarNomes()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    private List<String> listarNomes(){
        return Arrays.asList("Rodrigo","Joelma", "Casemiro", "Florence","Dieniffer", "George");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        TextView textView = (TextView) view;
        String mensagem = "Okkkk" + textView.getText();
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();

        String nome = (String) textView.getText();

        Intent intent = new Intent(this, ActivitySpinnerListView.class);
        intent.putExtra("nome",nome);
        startActivity(intent);
    }
}