package com.thew00xer.temishowroom;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnDetectionStateChangedListener;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.listeners.OnUserInteractionChangedListener;

public class CarFragment extends Fragment implements
        OnDetectionStateChangedListener,
        OnGoToLocationStatusChangedListener,
        OnUserInteractionChangedListener {

    private static Robot robot;

    public CarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        robot = Robot.getInstance();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        robot.removeOnGoToLocationStatusChangedListener(this);
        robot.removeOnDetectionStateChangedListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        robot.addOnGoToLocationStatusChangedListener(this);
        robot.addOnUserInteractionChangedListener(this);

        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_car, container, false);

        Button modelsButton = mainView.findViewById(R.id.modelsButton);
        modelsButton.setOnClickListener(view -> showMenu());

        Button salesButton = mainView.findViewById(R.id.salesButton);
        salesButton.setOnClickListener(view -> {
            Toast.makeText(requireActivity(), "CAR Our sales person will be with you shortly.", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(this::goHome, 2000);
        });

        Button returnButton = mainView.findViewById(R.id.returnButton);
        returnButton.setOnClickListener(view -> goHome());

        return mainView;
    }

    /**
     * Functions checks GoToLocation Status of robot with following parameters:
     * @param s name of location where Temi is going
     * @param s1 navigation status (eg. GOING, CALCULATING, COMPLETE) which is used here to determine that Robot arrived at set location
     * @param i Id Code that represents description of Navigation status
     * @param s2 informative description of navigation status (eg. obstacle info)
     */
    @Override
    public void onGoToLocationStatusChanged(@NonNull String s, @NonNull String s1, int i, @NonNull String s2) {
        if (!s.equals("home base") && s1.equals(COMPLETE)) {
            Toast.makeText(getContext(), "CAR I'm at car location.", Toast.LENGTH_SHORT).show();
            robot.addOnDetectionStateChangedListener(this);
            robot.setDetectionModeOn(true);
        }
        if (!s.equals("home base") && s1.equals(GOING)) {
            Toast.makeText(getContext(), "CAR I'm going to a car location.", Toast.LENGTH_SHORT).show();
            robot.removeOnDetectionStateChangedListener(this);
        }
    }

    @Override
    public void onDetectionStateChanged(int state) {
        switch (state) {
            case OnDetectionStateChangedListener.DETECTED:
                Toast.makeText(requireActivity(), "CAR Yay I can see you!", Toast.LENGTH_SHORT).show();
                break;
            case OnDetectionStateChangedListener.LOST:
                Toast.makeText(requireActivity(), "CAR Where did you go?", Toast.LENGTH_SHORT).show();
                break;
            case OnDetectionStateChangedListener.IDLE:
                Handler handler = new Handler();
                handler.postDelayed(() -> goHome(), 15000);
                break;
        }
    }

    private void showMenu() {
        robot.removeOnDetectionStateChangedListener(this);
        robot.removeOnGoToLocationStatusChangedListener(this);
        robot.removeOnUserInteractionChangedListener(this);
        Fragment fragment = new MenuFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void goHome() {
        robot.removeOnDetectionStateChangedListener(this);
        robot.removeOnGoToLocationStatusChangedListener(this);
        robot.removeOnUserInteractionChangedListener(this);
        Fragment fragment = new VideoFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        robot.goTo("home base");
    }

    @Override
    public void onUserInteraction(boolean b) {
        if (!b) {
            Handler handler = new Handler();
            handler.postDelayed(() -> goHome(), 15000);
        }
    }
}