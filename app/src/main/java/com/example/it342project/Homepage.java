package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TextView startExercise = findViewById(R.id.StartExercise);
        TextView viewAchievements =  findViewById(R.id.viewAchievements);
        TextView readArticles =  findViewById(R.id.readArticles);
        TextView viewProfile = findViewById(R.id.viewProfile);


        //-----------------------------------------------------------------------------------------

        startExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener

        //-----------------------------------------------------------------------------------------

        viewAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AchievementsMenu.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener

        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------

        readArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ArticlesMenu.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener

        //-----------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------

        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewProfile.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener

        //-----------------------------------------------------------------------------------------




    }// End of main method
}// End of class