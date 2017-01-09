package com.example.sergey.checkpoint.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.sergey.checkpoint.R;
import com.example.sergey.checkpoint.adapter.CustomAdapterTabResult;
import com.example.sergey.checkpoint.api.Controller;

public class ResultActivity extends AppCompatActivity {
    private Controller controller=new Controller();
    private CustomAdapterTabResult customAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_result);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Таблица результатов ");


        listView = (ListView) findViewById(R.id.listViewResult);
        customAdapter = new CustomAdapterTabResult(this, R.layout.custom_adapter_tabresrlt, controller.getAllWithAllResult());
        listView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu., menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                return true;
        }
    }


}
