package com.example.sergey.checkpoint.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergey.checkpoint.R;
import com.example.sergey.checkpoint.api.Controller;
import com.example.sergey.checkpoint.dao.TeamDao;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AddResultActivity extends AppCompatActivity {
    private ArrayAdapter<?> adapter;
    private ArrayAdapter<?> adapterBall;
    private Spinner spinner, spinnerBall;
    private Controller controller=new Controller();
    private Date date;
    private TextView textDateCalendar;
    private List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 3));
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Добавить результат ");

        textDateCalendar = (TextView) findViewById(R.id.textDateCalendar);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerBall = (Spinner) findViewById(R.id.spinnerBall);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, controller.getNameTeamList());
        adapterBall = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterBall.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinnerBall.setAdapter(adapterBall);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
                // date = new Date(year, month, dayOfMonth);
                date = new Date(calendar.getTimeInMillis());
                //textDateCalendar.setText(simpleDateFormat.format(date));
                textDateCalendar.setText(simpleDateFormat.format(date));
                // Toast.makeText(getApplicationContext(), date + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
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
                String s = (String) spinner.getSelectedItem();
                if (date != null) {
                    controller.saveResult(new Result(date, controller.findByName(s), Integer.parseInt(spinnerBall.getSelectedItem().toString())));
                    Toast.makeText(this, "Запись сохранена", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Заполните все поля пожалуйста", Toast.LENGTH_SHORT).show();
                }

                Log.d("Tag", "AddResultActivity- s: " + s + " " + controller.findByName(s) + " ||| " + spinnerBall.getSelectedItem().toString());
                return true;
            default:
                return true;
        }
    }
}
