package com.thew00xer.temishowroom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.Robot;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Robot.getInstance();

        getSupportFragmentManager().beginTransaction().add(R.id.container, new VideoFragment()).commit();
    }
}