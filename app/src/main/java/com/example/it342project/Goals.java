package com.example.it342project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.RowId;
import java.text.DateFormat;
import java.util.Calendar;

public class Goals extends AppCompatActivity {
    TableLayout TableView;
    TextView textv;
    Calendar calendar;
    String currentDate;
    DBSQLlight DB = new DBSQLlight(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
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