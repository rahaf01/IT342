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
   // DBSQLlight DB = new DBSQLlight(this);
  //  String email = Login.userEmail;
    Integer count = MainActivity.counter;
    // String CurrentDate = MainActivity.currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_goals);
        //-----------------------------------
        counter = findViewById(R.id.counter);
        date = findViewById(R.id.date);
        counter.setText(count);
       // date.setText(CurrentDate);
        //-----------------------------------

        /*
        calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TableView = findViewById(R.id.Achievements);
        Cursor res = DB.getAchievementdata(email);
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append(" " + res.getString(0)+"\n");
            buffer.append(" " + res.getString(1)+"\n");

        }

         */
    }
}