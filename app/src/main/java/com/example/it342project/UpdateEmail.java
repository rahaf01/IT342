package com.example.it342project;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdateEmail extends AppCompatActivity {

    ImageView backBtn;

    EditText preEmail;
    EditText newEmail;
    Button reset;

    DBSQLlight DB = new DBSQLlight(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);

        preEmail = findViewById(R.id.preEmail);
        newEmail = findViewById(R.id.newEmail);


        reset = findViewById(R.id.loginBtn);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPreEmail = preEmail.getText().toString();
                String enteredNewEmail = newEmail.getText().toString();


                if(enteredPreEmail.trim().isEmpty() && enteredNewEmail.trim().isEmpty()) {
                    Toast.makeText(UpdateEmail.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }// End of if statement

              else {

                  if (DB.doesEmailExist(enteredNewEmail)) {
                      Toast.makeText(UpdateEmail.this, "The email already exist", Toast.LENGTH_SHORT).show();

                  }
                  else {



                      if (DB.updateEmail(enteredPreEmail, enteredNewEmail)) {
                          Toast.makeText(UpdateEmail.this, "Email update success", Toast.LENGTH_SHORT).show();

                      }// End of inner if statement

                      else {
                          Toast.makeText(UpdateEmail.this, "Email update field", Toast.LENGTH_SHORT).show();

                      }// End of inner else statement

                  }// End of mid else statement

                }// End of else statement
            }// End of onClick()
        }); // End of setOnClickListener()

        backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewProfile.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener

    }// End of main method
}// End of class

