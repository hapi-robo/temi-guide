package com.hapirobo.temi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnDetectionDataChangedListener;
import com.robotemi.sdk.listeners.OnDetectionStateChangedListener;
import com.robotemi.sdk.listeners.OnRobotReadyListener;
import com.robotemi.sdk.listeners.OnUserInteractionChangedListener;
import com.robotemi.sdk.model.DetectionData;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements
        OnRobotReadyListener,
        OnDetectionStateChangedListener,
        OnDetectionDataChangedListener,
        OnUserInteractionChangedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Robot mRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize robot instance
        mRobot = Robot.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Add robot event listeners
        mRobot.addOnRobotReadyListener(this);
        mRobot.addOnDetectionStateChangedListener(this);
        mRobot.addOnDetectionDataChangedListener(this);
        mRobot.addOnUserInteractionChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Remove robot event listeners
        mRobot.removeOnRobotReadyListener(this);
        mRobot.removeOnDetectionStateChangedListener(this);
        mRobot.removeOnDetectionDataChangedListener(this);
        mRobot.removeOnUserInteractionChangedListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            Log.i(TAG, "Robot is ready");
            mRobot.hideTopBar(); // hide temi's top action bar when skill is active

            /*
             * |----------------------|------------------|---------------------------------------------|
             * | setDetectionModeOn() | setTrackUserOn() | Result                                      |
             * |----------------------|------------------|---------------------------------------------|
             * |         true         |       true       | Detection mode is on and tracking is on     |
             * |         true         |       false      | Detection mode is on and tracking is off    |
             * |         false        |       true       | Detection mode is **on** and tracking is on |
             * |         false        |       false      | Detection mode is off and tracking is off   |
             * |----------------------|------------------|---------------------------------------------|
             */
            Log.i(TAG, "Set detection mode: ON");
            mRobot.setDetectionModeOn(true, 2.0f); // Set detection mode on; set detection distance to be 2.0 m

            Log.i(TAG, "Set track user: ON");
            mRobot.setTrackUserOn(true); // Set tracking mode on
                                         // Note: When exiting the application, track user will still be enabled unless manually disabled
        }
    }

    @Override
    public void onDetectionStateChanged(int state) {
        final TextView textView = findViewById(R.id.detectionState);

        switch (state) {
            case OnDetectionStateChangedListener.IDLE:
                // No active detection and/or 10 seconds have passed since the last detection was lost
                Log.i(TAG, "OnDetectionStateChanged: IDLE");
                textView.setText("OnDetectionStateChanged: IDLE");
                break;
            case OnDetectionStateChangedListener.LOST:
                // When human-target is lost
                Log.i(TAG, "OnDetectionStateChanged: LOST");
                textView.setText("OnDetectionStateChanged: LOST");
                break;
            case OnDetectionStateChangedListener.DETECTED:
                // Human is detected
                Log.i(TAG, "OnDetectionStateChanged: DETECTED");
                textView.setText("OnDetectionStateChanged: DETECTED");
                break;
            default:
                // This should not happen
                Log.i(TAG, "OnDetectionStateChanged: UNKNOWN");
                textView.setText("OnDetectionStateChanged: UNKNOWN");
                break;
        }
    }

    @Override
    public void onDetectionDataChanged(@NotNull DetectionData detectionData) {
        if (detectionData.isDetected()) {
            final TextView textView = findViewById(R.id.detectionData);
            textView.setText("OnDetectionDataChanged: " + detectionData.getDistance() + " m");
            Log.i(TAG, "OnDetectionDataChanged: " + detectionData.getDistance() + " m");
        }
    }

    @Override
    public void onUserInteraction(boolean isInteracting) {
        final TextView textView = findViewById(R.id.userInteraction);

        if (isInteracting) {
            // User is interacting with the robot:
            // - User is detected
            // - User is interacting by touch, voice, or in telepresence-mode
            // - Robot is moving
            Log.i(TAG, "OnUserInteraction: TRUE");
            textView.setText("OnUserInteraction: TRUE");
        } else {
            // User is not interacting with the robot
            Log.i(TAG, "OnUserInteraction: FALSE");
            textView.setText("OnUserInteraction: FALSE");
        }
    }
}