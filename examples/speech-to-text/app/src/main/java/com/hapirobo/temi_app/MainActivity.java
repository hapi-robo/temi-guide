package com.hapirobo.temi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnConversationStatusChangedListener;
import com.robotemi.sdk.listeners.OnRobotReadyListener;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements
        OnRobotReadyListener,
        Robot.AsrListener,
        OnConversationStatusChangedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Robot sRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize robot instance
        sRobot = Robot.getInstance();

        // Initialize test button
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sRobot.askQuestion("Hello");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Add robot event listeners
        sRobot.addOnRobotReadyListener(this);
        sRobot.addAsrListener(this);
        sRobot.addOnConversationStatusChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Remove robot event listeners
        sRobot.removeOnRobotReadyListener(this);
        sRobot.removeAsrListener(this);
        sRobot.removeOnConversationStatusChangedListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            Log.i(TAG, "Robot is ready");
            sRobot.hideTopBar(); // hide temi's top action bar when skill is active
        }
    }

    @Override
    public void onAsrResult(@NotNull String asrResult) {
        final TextView textView = findViewById(R.id.asrResult);

        Log.i(TAG, "ASR Result: " + asrResult);
        textView.setText("ASR Result: " + asrResult);

        sRobot.finishConversation(); // stop ASR listener
    }

    @Override
    public void onConversationStatusChanged(int status, @NotNull String text) {
        final TextView textView = findViewById(R.id.conversationStatus);

        switch (status) {
            case IDLE:
                Log.i(TAG, "Status: IDLE | Text: " + text);
                textView.setText("Status: IDLE | Text: " + text);
                break;
            case LISTENING:
                Log.i(TAG, "Status: LISTENING | Text: " + text);
                textView.setText("Status: LISTENING | Text: " + text);
                break;
            case THINKING:
                Log.i(TAG, "Status: THINKING | Text: " + text);
                textView.setText("Status: THINKING | Text: " + text);
                break;
            case SPEAKING:
                Log.i(TAG, "Status: SPEAKING | Text: " + text);
                textView.setText("Status: SPEAKING | Text: " + text);
                break;
            default:
                Log.i(TAG, "Status: UNKNOWN | Text: " + text);
                textView.setText("Status: UNKNOWN | Text: " + text);
                break;
        }
    }
}