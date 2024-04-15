package com.example.trackyourscrolls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        TimerTask splash = new TimerTask() {
            @Override
            public void run() {
                splashtime();
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000l;
        timer.schedule(splash,delay);
    }
    public  void splashtime(){

        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);

    }
}