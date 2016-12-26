package com.example.sergey.checkpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sergey.checkpoint.dao.ComandaDao;

public class InfoActivity extends AppCompatActivity {
    TextView textView;
    ComandaDao comandaDao = new ComandaDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView = (TextView) findViewById(R.id.textView);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Информация о команде");

        String s=getIntent().getStringExtra("NameComanda");

        textView.setText(comandaDao.findByName(s).toString());
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
