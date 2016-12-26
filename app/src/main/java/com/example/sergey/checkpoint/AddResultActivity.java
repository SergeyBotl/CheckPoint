package com.example.sergey.checkpoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sergey.checkpoint.dao.ComandaDao;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Comanda;
import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddResultActivity extends AppCompatActivity {
    ArrayAdapter<?> adapter;
    Spinner spinner;
    ComandaDao comandaDao = new ComandaDao();
    ResultDao resultDao = new ResultDao();
    List<Comanda> comandaList = new ArrayList<>(comandaDao.getAll());
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText = (EditText) findViewById(R.id.editTextBalls);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getlist());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    List<Comanda> getlist() {

        Collections.sort(comandaList, new Comparator<Comanda>() {
            @Override
            public int compare(Comanda comanda, Comanda t1) {
                return comanda.getNameComanda().compareTo(t1.getNameComanda());
            }
        });
        return comandaList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                // Intent intent = new Intent(this, SaveActivity.class);
                // startActivity(intent);
                finish();
                return true;
            case R.id.save:
                Comanda c = (Comanda) spinner.getSelectedItem();
                resultDao.save(new Result(c, editText.getText().toString()));
                return true;
            default:
                return true;
        }
    }
}
