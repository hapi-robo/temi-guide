package com.thew00xer.temishowroom;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnDetectionStateChangedListener;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;

public class MenuFragment extends Fragment implements
        OnGoToLocationStatusChangedListener,
        OnDetectionStateChangedListener {

    private static Robot robot;

    public MenuFragment() {
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
        robot.addOnDetectionStateChangedListener(this);

        View mainView = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton menuButton1 = mainView.findViewById(R.id.menuButton1);
        menuButton1.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Corolla", Toast.LENGTH_SHORT).show();
            robot.goTo("corolla");
        });
        ImageButton menuButton2 = mainView.findViewById(R.id.menuButton2);
        menuButton2.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Crown", Toast.LENGTH_SHORT).show();
            robot.goTo("crown");
        });
        ImageButton menuButton3 = mainView.findViewById(R.id.menuButton3);
        menuButton3.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Prius", Toast.LENGTH_SHORT).show();
            robot.goTo("prius");
        });
        ImageButton menuButton4 = mainView.findViewById(R.id.menuButton4);
        menuButton4.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Rav4", Toast.LENGTH_SHORT).show();
            robot.goTo("rav4");
        });
        ImageButton menuButton5 = mainView.findViewById(R.id.menuButton5);
        menuButton5.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Yaris", Toast.LENGTH_SHORT).show();
            robot.goTo("yaris");
        });
        ImageButton menuButton6 = mainView.findViewById(R.id.menuButton6);
        menuButton6.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Yaris GR", Toast.LENGTH_SHORT).show();
            robot.goTo("yarisgr");
        });

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
        if (s.equals("home base") && s1.equals(COMPLETE)) {
            Toast.makeText(getContext(), "MENU I'm HOME.", Toast.LENGTH_SHORT).show();
        }
        if (s.equals("home base") && s1.equals(GOING)) {
            Toast.makeText(getContext(), "MENU I'm going HOME.", Toast.LENGTH_SHORT).show();
            robot.setDetectionModeOn(false);
            robot.removeOnDetectionStateChangedListener(this);
        }
        if (!s.equals("home base") && (s1.equals(GOING))) {
            Toast.makeText(getContext(), "MENU I'm going to CAR location.", Toast.LENGTH_SHORT).show();
            robot.setDetectionModeOn(false);
            robot.removeOnDetectionStateChangedListener(this);
            robot.removeOnGoToLocationStatusChangedListener(this);
            showCar();
        }
    }

    private void showCar() {
        Fragment fragment = new CarFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void playVideo() {
        Fragment fragment = new VideoFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDetectionStateChanged(int i) {
        switch (i) {
            case OnDetectionStateChangedListener.DETECTED:
                Toast.makeText(requireActivity(), "MENU Yay I can see you!", Toast.LENGTH_SHORT).show();
                break;
            case OnDetectionStateChangedListener.LOST:
                Toast.makeText(requireActivity(), "MENU Where did you go?", Toast.LENGTH_SHORT).show();
                break;
            case OnDetectionStateChangedListener.IDLE:
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    Toast.makeText(requireActivity(), "MENU home base", Toast.LENGTH_SHORT).show();
                    playVideo();
                    robot.goTo("home base");
                    robot.setDetectionModeOn(false);
                    robot.removeOnDetectionStateChangedListener(this);
                    robot.removeOnGoToLocationStatusChangedListener(this);
                }, 5000);
                break;
        }
    }
}