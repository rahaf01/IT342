package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class UserGoals extends AppCompatActivity {

    ImageView backBtn;

    TableLayout TableView;
    TextView counter,date;
    Calendar calendar;
    String currentDate;
    // DBSQLlight DB = new DBSQLlight(this);
    //  String email = Login.userEmail;
    String count = MainActivity.counter.toString();
    // String CurrentDate = MainActivity.currentDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_goals);

        backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ArticlesMenu.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener


        counter = findViewById(R.id.counter);
        date = findViewById(R.id.date);

        counter.setText(count);

        // date.setText(CurrentDate);
        //-----------------------------------
    }
}