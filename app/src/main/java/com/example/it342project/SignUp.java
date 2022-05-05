package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText conf_Password;

    Button signup;

    DBSQLlight DB = new DBSQLlight(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conf_Password = findViewById(R.id.conf_password);

        signup = findViewById(R.id.signupBtn);

        // When sign up btn is clicked
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEmail = email.getText().toString();
                String newPassword = password.getText().toString();
                String conf_newPassword = conf_Password.getText().toString();

                if(newEmail.trim().isEmpty() || newPassword.trim().isEmpty() || conf_newPassword.trim().isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }// End of if statement
                else {
                    if(newPassword.equals(conf_newPassword)) {
                        Boolean isUserRegistered = DB.doesEmailExist(newEmail);

                        if (isUserRegistered == false) {
                            Boolean insert = DB.insertData(newEmail, newPassword);

                            if (insert) {
                            //    username = newUsername;
                                Toast.makeText(SignUp.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Homepage.class);
                                startActivity(intent);
                            }// End of inner if statement - Account creation success
                            else {
                                Toast.makeText(SignUp.this, "Account creation failed", Toast.LENGTH_SHORT).show();
                            }// End of inner else statement - Account creation fail
                        }// End of inner if statement -- Username not exist
                        else {
                            Toast.makeText(SignUp.this, "Username already exists! Please choose another one", Toast.LENGTH_SHORT).show();
                        }// End of inner else statement - Username exist
                    } // End of inner if statement - newPassword and repass are equal
                    else {
                        Toast.makeText(SignUp.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }// End of inner else statement - newPassword and repass are not equal
                }// End of else statement - fields are not empty
            }// End of onClick
        });// End of  signup.setOnClickListener




    }
}