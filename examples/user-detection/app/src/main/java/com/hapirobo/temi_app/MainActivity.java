package com.hapirobo.temi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

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
        OnUserInteractionChangedListener,
        OnDetectionDataChangedListener {
    private static final String TAG = "MainActivity";
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
            sRobot.setDetectionModeOn(true); // DEBUG
        }
    }

    @Override
    public void onDetectionDataChanged(@NotNull DetectionData detectionData) {
        Log.i(TAG, "Detection Data: ");
        Log.i(TAG, "- Angle: " + detectionData.getAngle());
        Log.i(TAG, "- Distance: " + detectionData.getDistance());
        Log.i(TAG, "- isDetected: " + detectionData.isDetected());
    }

    @Override
    public void onDetectionStateChanged(int state) {
        switch (state) {
            case OnDetectionStateChangedListener.IDLE:
                Log.i(TAG, "OnDetectionStateChanged: IDLE");
                break;
            case OnDetectionStateChangedListener.LOST:
                Log.i(TAG, "OnDetectionStateChanged: LOST");
                break;
            case OnDetectionStateChangedListener.DETECTED:
                Log.i(TAG, "OnDetectionStateChanged: DETECTED");
                break;
            default:
                Log.i(TAG, "OnDetectionStateChanged: UNKNOWN");
                break;
        }
    }

    @Override
    public void onUserInteraction(boolean isInteracting) {
        if (isInteracting) {
            Log.i(TAG, "OnUserInteraction: TRUE");
        } else {
            Log.i(TAG, "OnUserInteraction: FALSE");
        }
    }
}