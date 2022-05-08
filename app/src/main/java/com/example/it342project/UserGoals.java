package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class UserGoals extends AppCompatActivity {

    TableLayout TableView;
    TextView counter,date;
    Calendar calendar;
    String currentDate;
    Integer count = MainActivity.counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_goals);
        //-----------------------------------
        counter = findViewById(R.id.counter);
        date = findViewById(R.id.date);
        counter.setText(count);

    }
}