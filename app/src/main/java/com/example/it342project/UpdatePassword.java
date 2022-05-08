package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdatePassword extends AppCompatActivity {

    ImageView backBtn;

    EditText preEmail;
    EditText newPassword;
    Button reset;

    DBSQLlight DB = new DBSQLlight(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        preEmail = findViewById(R.id.preEmail);
        newPassword = findViewById(R.id.newEmail);


        reset = findViewById(R.id.loginBtn);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPreEmail = preEmail.getText().toString();
                String enteredNewPassword = newPassword.getText().toString();


                if(enteredPreEmail.trim().isEmpty() && enteredNewPassword.trim().isEmpty()) {
                    Toast.makeText(UpdatePassword.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }// End of if statement

                else {

                    if (DB.updatePassword(enteredPreEmail, enteredNewPassword)) {
                        Toast.makeText(UpdatePassword.this, "Password update success", Toast.LENGTH_SHORT).show();

                    }// End of inner if statement

                    else {
                        Toast.makeText(UpdatePassword.this, "Password update field", Toast.LENGTH_SHORT).show();

                    }// End of inner else statement

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


    }
}