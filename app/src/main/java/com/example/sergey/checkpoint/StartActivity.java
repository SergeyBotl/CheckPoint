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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<Result> adapter;
    ResultDao resultDao=new ResultDao();
    List<Result>resultsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        getSupportActionBar().setTitle("Таблица ");
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getlist());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Result item = (Result) adapterView
                        .getItemAtPosition(i);
                Intent intent=new Intent(StartActivity.this,InfoActivity.class);
                intent.putExtra("NameComanda",item.getNameComanda().toString());
                Log.d("Tag",""+item.getNameComanda().toString());
                startActivity(intent);
            }
        });
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
            default:
                return true;
        }
    }

    List<Result>getlist(){
        resultsList=resultDao.getAll();
        Collections .sort(resultsList, new Comparator<Result>() {
            @Override
            public int compare(Result result, Result t1) {
                return result.getBall()-t1.getBall();
            }
        });
        return resultsList;
    }
}
