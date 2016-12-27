package com.example.sergey.checkpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sergey.checkpoint.dao.ComandaDao;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Comanda;
import com.example.sergey.checkpoint.entity.Result;

public class InfoActivity extends AppCompatActivity {
    TextView textView;
    private ComandaDao comandaDao = new ComandaDao();
    private ResultDao resultDao = new ResultDao();
    ArrayAdapter<Result> adapter;
    ListView listView;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView = (TextView) findViewById(R.id.textView);
        String s = getIntent().getStringExtra("NameComanda");
        Comanda comanda = comandaDao.findByName(s);
        Log.d("Tag", "s: " + s + " ++ ");
        textView.setText("" + comanda.toString());


        customAdapter=new CustomAdapter(this,R.layout.custom_adapter,resultDao.allResultsForComanda(s));
        listView = (ListView) findViewById(R.id.listViewComanda);

        View header= getLayoutInflater().inflate(R.layout.header, null);
        listView.addHeaderView(header);
        
        listView.setAdapter(customAdapter);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Информация о команде");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.item_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, StartActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return true;
        }
    }
}
