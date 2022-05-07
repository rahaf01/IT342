package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class AchievementsMenu extends AppCompatActivity {

    Spinner menu;
    ArrayAdapter<CharSequence> adapter;

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements_menu);

        menu = (Spinner) findViewById(R.id.articlesMenuSpinner);

        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.achievement, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapter);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).toString().equals("What is 4-7-8 exercise")) {
//                    Intent intent = new Intent(getApplicationContext(),ArticleOne.class);
//                    startActivity(intent);

                }// End of if statement

                else if (parent.getItemAtPosition(position).toString().equals("Happy habits to relieve anxiety and stress")) {

//                    Intent intent = new Intent(getApplicationContext(),ArticleTwo.class);
//                    startActivity(intent);

                }// End of if else statement

                else{

                }// End of else statement
            }//End of onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        backBtn = (ImageView) findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Homepage.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener



    }
}