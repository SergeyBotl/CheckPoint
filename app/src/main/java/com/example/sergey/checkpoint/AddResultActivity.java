package com.example.sergey.checkpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sergey.checkpoint.dao.ComandaDao;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Comanda;
import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AddResultActivity extends AppCompatActivity {
    private ArrayAdapter<?> adapter;
    private ArrayAdapter<?> adapterBall;
    private Spinner spinner, spinnerBall;
    private ComandaDao comandaDao = new ComandaDao();
    private ResultDao resultDao = new ResultDao();
    private List<String> comandaNameList = new ArrayList<>(comandaDao.getColumnName());
    private CalendarView calendarView;
    List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 3));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Добавить результат ");

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerBall = (Spinner) findViewById(R.id.spinnerBall);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getlist());
        adapterBall = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterBall.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinnerBall.setAdapter(adapterBall);
    }


    List<String> getlist() {

        Collections.sort(comandaNameList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        return comandaNameList;
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
                // editText.getText().toString()
                String s = (String) spinner.getSelectedItem();
                Date date =new Date(calendarView.getDate()) ;

                resultDao.save(new Result(date, comandaDao.findByName(s), spinnerBall.getSelectedItem().toString()));
                Log.d("Tag", "AddResultActivity- s: " + s + " " + comandaDao.findByName(s) + " ||| " + spinnerBall.getSelectedItem().toString());

                return true;
            default:
                return true;
        }
    }
}
