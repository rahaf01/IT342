package com.example.it342project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;

import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    Spinner menu;
    ImageView menuButton;
    ArrayAdapter <CharSequence> adapter;

    Button startBreathBtn;
    ImageView imageView;
    ImageView backBtn;
    TextView timer;
    TextView textGuide;

    CountDownTimer countDownTimer;
    long inhealTime = 5000; // 4 seconds starting from 4
    long holdTime = 8000; // 7 seconds starting from 7
    long exhealTime = 9000; // 8 seconds starting from 8
    boolean timeRunning;


    boolean isDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBreathBtn = (Button) findViewById(R.id.startBreathBtn);
        imageView = (ImageView) findViewById(R.id.imageView3);
        timer = (TextView) findViewById(R.id.textViewTimer);
        textGuide = (TextView) findViewById(R.id.textView);
        backBtn = (ImageView) findViewById(R.id.backBtn);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Homepage.class);
                startActivity(intent);
            }// End of onClick()
        }); // End of setOnClickListener

        startBreathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inhealTime = 5000; // 4 seconds starting from 4
                holdTime = 8000; // 7 seconds starting from 7
                exhealTime = 9000; // 8 seconds starting from 8
                inheal();
             //   Toast.makeText(MainActivity.this, "Button is clicked", Toast.LENGTH_SHORT).show();

            }// End of onClick()
        }); // End of setOnClickListener


//        menu = (Spinner) findViewById(R.id.spinner);
//        menuButton = (ImageView) findViewById(R.id.imageView) ;
//
//        adapter = ArrayAdapter.createFromResource(this, R.array.pages, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        menu.setAdapter(adapter);

//        List <String> myMenu = new ArrayList<>();
//        myMenu.add(0, "Go to ...");
//        myMenu.add("Goal");
//        myMenu.add("Articles");
//
//        //Style the dropdown menu
//        ArrayAdapter <String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, myMenu);
//
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        menu.setAdapter(myAdapter);


//        menuButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                menu = (Spinner) findViewById(R.id.spinner);
//                menuButton = (ImageView) findViewById(R.id.imageView) ;
//
//                adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.pages, android.R.layout.simple_spinner_item);
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                menu.setAdapter(adapter);
//
//                menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                        if (parent.getItemAtPosition(position).equals("")) {
//
//                        }// End of if statment
//
//                        else {
//                            Toast.makeText(getBaseContext(), parent.getItemAtPosition(position).toString() + " Selected", Toast.LENGTH_LONG).show();
//                        }// End of else statement
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });
////
//
//            }// End of onClick()
//        }); // End of setOnClickListener








    }// End of main method

    public void inheal() {

        textGuide.setText("Inhale");
        ViewAnimator
                .animate(imageView)
                    .scale(1,0)
                    .rotation(270)
                    .duration(5000) // it is counted by milli second

                .start();

        startInhealTime();

//        if (timeRunning) {
//            // Stop timer
//            stopInhealTime();
//        }// End of if statement
//        else {
//            // Start timer
//            startInhealTime();
//        }// End of else statement
    }// End of startBreath()


    public void startInhealTime () {
        //Toast.makeText(MainActivity.this, "In Inheal time", Toast.LENGTH_SHORT).show();

        countDownTimer = new CountDownTimer (inhealTime, 1000) {
            @Override
            public void onTick(long l) {
                inhealTime = l;
                changeTimeText();
            } // End of onTick ()

            @Override
            public void onFinish() {
            }// End of onFinish ()
        } .start(); // End of CountDownTimer()

        timeRunning = true;
    }// End of start ()

    public void stopInhealTime () {
        countDownTimer.cancel();
        startBreathBtn.setText("Start after inhale");
        timeRunning = false;

    }// End of Stop ()

    public void changeTimeText () {

        int seconds = (int) inhealTime % 60000 / 1000;
        String secondsTime = "" + seconds;
        timer.setText(secondsTime);

        if (seconds == 0)
            hold();

    }// End of changeTimeText ()

    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    public void hold () {
//        ViewAnimator
//                .animate(imageView)
//                    .startDelay(8000)
//                    .scale(0,1)
//                    .rotation(360)
//                    .duration(9000) // it is counted by milli second
//                .start();
//
      textGuide.setText("Hold");
      startHoldTime();

    }// End of hold

    public void startHoldTime () {
        //Toast.makeText(MainActivity.this, "In Hold time", Toast.LENGTH_SHORT).show();

        countDownTimer = new CountDownTimer (holdTime, 1000) {
            @Override
            public void onTick(long l) {
                holdTime = l;
                changeHoldTimeText();
            } // End of onTick ()

            @Override
            public void onFinish() {
            }// End of onFinish ()
        } .start(); // End of CountDownTimer()

        timeRunning = true;
      //  startBreathBtn.setText("Hold");


    }// End of startHoldTime ()

    public void stopHoldTime () {

        countDownTimer.cancel();
        startBreathBtn.setText("Start after hold");
        timeRunning = false;

    }// End of stopHoldTime ()

    public void changeHoldTimeText () {

        int seconds = (int) holdTime % 60000 / 1000;
        String secondsTime = "" + seconds;
        timer.setText(secondsTime);

        if (seconds == 0)
            exheal ();

    }// End of changeTimeText ()

    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------

    public void exheal () {

        textGuide.setText("Exhale");
        ViewAnimator
                .animate(imageView)
            //    .startDelay(8000)
                .scale(0,1)
                .rotation(360)
                .duration(9000) // it is counted by milli second
                .start();

        startExhealTime();

    }

    public void startExhealTime () {

        countDownTimer = new CountDownTimer (exhealTime, 1000) {
            @Override
            public void onTick(long l) {
                exhealTime = l;
                changeExhealTimeText();
            } // End of onTick ()

            @Override
            public void onFinish() {
            }// End of onFinish ()
        } .start(); // End of CountDownTimer()

        timeRunning = true;
      //  startBreathBtn.setText("Exheal");

        

    }// End of startExhalTime ()

    public void stopExhealTime () {

        countDownTimer.cancel();
    //    startBreathBtn.setText("Start after hold");
        timeRunning = false;


    }// End of stopExhealTime ()

    public void changeExhealTimeText () {

        int seconds = (int) exhealTime % 60000 / 1000;
        String secondsTime = "" + seconds;
        timer.setText(secondsTime);



    }// End of changeTimeText ()

    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------


  //  @Override
    public void whenItemClicked(int index) {

    }// End of whenItemClicked()


} // End of the class