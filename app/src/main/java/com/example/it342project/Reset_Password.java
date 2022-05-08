package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Reset_Password extends AppCompatActivity {

    ImageView backBtn;

    EditText email;
    EditText password;
    EditText conf_Password;

    Button reset;


    DBSQLlight DB = new DBSQLlight(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conf_Password = findViewById(R.id.conf_password);

        reset = findViewById(R.id.resetBtn);

        // When sign up btn is clicked
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entredEmail = email.getText().toString();
                String newPassword = password.getText().toString();
                String conf_newPassword = conf_Password.getText().toString();

                if(newPassword.trim().isEmpty() || conf_newPassword.trim().isEmpty()) {
                    Toast.makeText(Reset_Password.this, "Please enter all of the fields", Toast.LENGTH_SHORT).show();
                }// End of if statement
                else {
                    if(newPassword.equals(conf_newPassword)) {

                       if (DB.updatePassword(entredEmail, newPassword))  {

                           Toast.makeText(Reset_Password.this, "Password updated successfully", Toast.LENGTH_SHORT).show();

                        }// End of inner if statement

                        else {
                           Toast.makeText(Reset_Password.this, "Password update failed", Toast.LENGTH_SHORT).show();

                        }// End of inner else statement

                    } // End of inner if statement - newPassword and repass are equal
                    else {
                        Toast.makeText(Reset_Password.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }// End of inner else statement - newPassword and repass are not equal
                }// End of else statement - fields are not empty

                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);

            }// End of onClick
        });// End of  signup.setOnClickListener


        backBtn = (ImageView) findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener



    } // End of main method
}// End of class