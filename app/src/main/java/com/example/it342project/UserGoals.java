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
    TextView textv;
    Calendar calendar;
    String currentDate;
    DBSQLlight DB = new DBSQLlight(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_goals);
        calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TableView = findViewById(R.id.Achievements);
        textv = findViewById(R.id.textView4);
        Cursor res = DB.getdata();
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append(" " + res.getString(0)+"\n");
        }
    }
}