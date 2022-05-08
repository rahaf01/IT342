package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static String userEmail;

    EditText email;
    EditText password;

    Button login;
    TextView signup;

    TextView forgetPassword;

    DBSQLlight DB = new DBSQLlight(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.loginBtn);

        signup = findViewById(R.id.textView6);

        forgetPassword = findViewById(R.id.textView3);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener()


        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Reset_Password.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener()




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = email.getText().toString();
                String enteredPassword = password.getText().toString();

                if(enteredEmail.trim().isEmpty() || enteredPassword.trim().isEmpty()) {
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }// End of if statement
                else {
                    if (DB.doesAccountExist(enteredEmail , enteredPassword)) {
                       userEmail = enteredEmail;
                        Intent intent = new Intent(getApplicationContext(),Homepage.class);
                        startActivity(intent);
                    }// End of if statement - User account does exist
                    else {
                        Toast.makeText(Login.this, "Username or password is not correct", Toast.LENGTH_SHORT).show();
                    } // End of else statement - User account does not exist
                }// End of else statement - All fields are not empty
            }// End of onClick()
        }); // End of setOnClickListener(



    }// End of main method
}// End of class