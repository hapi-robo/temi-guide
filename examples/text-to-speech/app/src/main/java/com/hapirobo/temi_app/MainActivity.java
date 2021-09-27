package com.hapirobo.temi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnRobotReadyListener;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity implements OnRobotReadyListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Robot sRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare a queue of phrases
        final Queue<String> queue = new LinkedList<>();
        queue.add("こんにちは");
        queue.add("元気ですか");

        // Initialize robot instance
        sRobot = Robot.getInstance();

        // Register TTS listener
        sRobot.addTtsListener(new Robot.TtsListener() {
            @Override
            public void onTtsStatusChanged(@NotNull TtsRequest ttsRequest) {
                Log.i(TAG, "Status:" + ttsRequest.getStatus());
                if (ttsRequest.getStatus() == TtsRequest.Status.COMPLETED) {
                    if (!queue.isEmpty()) {
                        sRobot.speak(TtsRequest.create(queue.remove(), false));
                    }
                }
            }
        });

        // Initialize test button
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Command robot to speak
               sRobot.speak(TtsRequest.create(queue.remove(), false, TtsRequest.Language.SYSTEM)); // In Japanese, uses Google Text-to-Speech
//               sRobot.speak(TtsRequest.create(queue.remove(), false, TtsRequest.Language.JA_JP)); // In Japanese uses Microsoft Text-to-Speech
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Add robot event listeners
        sRobot.addOnRobotReadyListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Remove robot event listeners
        sRobot.removeOnRobotReadyListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            Log.i(TAG, "Robot is ready");
        }
    }
}