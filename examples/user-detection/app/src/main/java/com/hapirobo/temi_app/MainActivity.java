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
        OnUserInteractionChangedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Robot sRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize robot instance
        sRobot = Robot.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Add robot event listeners
        sRobot.addOnRobotReadyListener(this);
        sRobot.addOnDetectionStateChangedListener(this);
        sRobot.addOnDetectionStateChangedListener(this);
        sRobot.addOnUserInteractionChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Remove robot event listeners
        sRobot.removeOnRobotReadyListener(this);
        sRobot.removeOnDetectionStateChangedListener(this);
        sRobot.removeOnDetectionStateChangedListener(this);
        sRobot.removeOnUserInteractionChangedListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            Log.i(TAG, "Robot is ready");
            sRobot.hideTopBar(); // hide temi's top action bar when skill is active

            Log.i(TAG, "Set detection mode: ON");
            sRobot.setDetectionModeOn(true);
        }
    }

    /**
     * This is listener will return true if:
     *  - User is detected
     *  - User is interacting by touch, voice, or in telepresence-mode
     *  - Robot is moving
     * @param isInteracting True is user is interacting with the robot; false otherwise.
     */
    @Override
    public void onUserInteraction(boolean isInteracting) {
        final TextView textView = findViewById(R.id.userInteraction);

        if (isInteracting) {
            Log.i(TAG, "OnUserInteraction: TRUE");
            textView.setText("OnUserInteraction: TRUE");
        } else {
            Log.i(TAG, "OnUserInteraction: FALSE");
            textView.setText("OnUserInteraction: FALSE");
        }
    }

    /**
     * This listener will return the detection state.
     * @param state
     *  - IDLE: No active detection and/or 10 seconds have passed since the last detection was lost
     *  - DETECTED: When human is detected
     *  - LOST: When human-target is lost
     */
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
}