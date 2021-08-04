package com.hapirobo.temi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnRobotReadyListener;
import com.robotemi.sdk.navigation.listener.OnCurrentPositionChangedListener;
import com.robotemi.sdk.navigation.model.Position;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements
        OnRobotReadyListener,
        OnCurrentPositionChangedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Robot mRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize robot instance
        mRobot = Robot.getInstance();

        // Initialize Go-To position button
        final EditText editXCoordinate = findViewById(R.id.editXCoordinate);
        final EditText editYCoordinate = findViewById(R.id.editYCoordinate);
        Button goToPosition = findViewById(R.id.buttonGoToPosition);
        goToPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Coordinates are defined as distances (m) from the Home Base
                // where,
                // X is pointed directly away from the Home Base
                // Y is pointed to the left of the Home Base
                int xCoordinate = 0; // Robot's position wrt the Home Base [m]
                int yCoordinate = 0; // Robot's position wrt the Home Base [m]
                int yaw = 0; // Robot's yaw-rotation wrt the Home Base [deg]

                // Convert input string to integer
                try {
                    xCoordinate =  Integer.parseInt(editXCoordinate.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                try {
                    yCoordinate = Integer.parseInt(editYCoordinate.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                Log.i(TAG, "X: " + xCoordinate + " | Y: " + yCoordinate);

                // Send robot to the XY position
                mRobot.goToPosition(new Position((float)xCoordinate, (float)yCoordinate, (float)yaw, 0));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Add robot event listeners
        mRobot.addOnRobotReadyListener(this);
        mRobot.addOnCurrentPositionChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Remove robot event listeners
        mRobot.removeOnRobotReadyListener(this);
        mRobot.removeOnCurrentPositionChangedListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            Log.i(TAG, "Robot is ready");
            mRobot.hideTopBar(); // hide temi's ActionBar when skill is active
        }
    }

    @Override
    public void onCurrentPositionChanged(@NotNull Position position) {
        final TextView textViewPosition = findViewById(R.id.textViewPosition);
        String str = "X: " + position.getX() + " Y: " + position.getY();
        Log.i(TAG, str);
        textViewPosition.setText(str);
    }
}