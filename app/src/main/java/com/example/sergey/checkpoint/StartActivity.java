package com.example.sergey.checkpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Comanda;
import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<Result> adapter;
    private ResultDao resultDao = new ResultDao();
    private List<Result> resultsList ;//= new ArrayList<>(resultDao.getAll());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportActionBar().setTitle("Таблица ");
        listView = (ListView) findViewById(R.id.listView);

        View header= getLayoutInflater().inflate(R.layout.header, null);
        listView.addHeaderView(header);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               final Result result = (Result)adapterView.getItemAtPosition(i);
                String s=result.getNameComanda().getNameComanda();
                Intent intent = new Intent(StartActivity.this, InfoActivity.class);
                intent.putExtra("NameComanda", result.getNameComanda().getNameComanda());
                //Log.d("Tag", "" + result.getNameComanda().toString());
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getlist());
        listView.setAdapter(adapter);
        Log.d("Tag", "onStart" );
        //adapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, AddResultActivity.class);
                startActivity(intent);
                return true;
            case R.id.results:
                 intent = new Intent(this, TabResultActivity.class);
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }

    List<Result> getlist() {
        resultsList = new ArrayList<>(resultDao.getAll());
        Collections.sort(resultsList, new Comparator<Result>() {
            @Override
            public int compare(Result result, Result t1) {
                return result.getBall().compareTo(t1.getBall());
            }

    });
        return resultsList;
    }
}
