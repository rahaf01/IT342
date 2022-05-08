package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ViewProfile extends AppCompatActivity {


    Spinner menu;
    ImageView backBtn;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        menu = (Spinner) findViewById(R.id.articlesMenuSpinner);

        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.update, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapter);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).toString().equals("Email")) {
                    Intent intent = new Intent(getApplicationContext(),UpdateEmail.class);
                    startActivity(intent);

                }// End of if statement

                else if (parent.getItemAtPosition(position).toString().equals("Password")) {

                    Intent intent = new Intent(getApplicationContext(),UpdatePassword.class);
                    startActivity(intent);

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



    } // End of main method
}// End of class