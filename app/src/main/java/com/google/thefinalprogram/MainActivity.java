package com.google.thefinalprogram;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private final int WAIT_TIME = 2500;
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        getSupportActionBar().hide();
        ////////////////////////////////////write your code down////////////////

        uiHandler = new Handler(); // anything posted to this handler will run on the UI Thread
        final Runnable onUi = new Runnable() {
            @Override
            public void run() {
                // this will run on the main UI thread
                Intent enternames = new Intent (MainActivity.this, The2Activity.class);
                startActivity (enternames);
                MainActivity.this.finish();
            }
        };

        Runnable background = new Runnable() {
            @Override
            public void run() {
                // This is the delay
                try {
                    Thread.sleep ( WAIT_TIME );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                // This will run on a background thread
                //Simulating a long running task
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                System.out.println("Going to Profile Data");
                uiHandler.post( onUi );
            }
        };

        new Thread( background ).start();



    }// end Main






}// end class
