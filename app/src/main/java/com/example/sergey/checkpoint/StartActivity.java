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

import com.example.sergey.checkpoint.adapter.CustomAdapter;
import com.example.sergey.checkpoint.addresult.AddResultActivity;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    private ListView listView;
    private ResultDao resultDao = new ResultDao();
    private List<Result> resultsList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportActionBar().setTitle("Таблица ");
        listView = (ListView) findViewById(R.id.listView);

        View header = getLayoutInflater().inflate(R.layout.header, null);
        listView.addHeaderView(header);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Result result = (Result) adapterView.getItemAtPosition(i);
                 Intent intent = new Intent(StartActivity.this, InfoActivity.class);
                intent.putExtra("NameComanda", result.getTeam().getName());
                //Log.d("Tag", "" + result.getNameComanda().toString());
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        customAdapter = new CustomAdapter(this, R.layout.custom_adapter, getlist());
         listView.setAdapter(customAdapter);
        Log.d("Tag", "onStart");
         super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_result:
                Intent intent = new Intent(this, AddResultActivity.class);
                startActivity(intent);
                return true;
            case R.id.show_results:
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
                return result.getBallInt()-t1.getBallInt();
            }
        });
        return resultsList;
    }
}
