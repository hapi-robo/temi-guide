package com.thew00xer.temishowroom;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnDetectionStateChangedListener;
import com.robotemi.sdk.listeners.OnMovementStatusChangedListener;

public class VideoFragment extends Fragment implements OnDetectionStateChangedListener {

    private static Robot robot;

    public VideoFragment() {
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
        robot.removeOnDetectionStateChangedListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        robot.addOnDetectionStateChangedListener(this);

        View mainView = inflater.inflate(R.layout.fragment_video, container, false);

        //File[] listFiles;
        //File videoDirectory = new File(Environment.getExternalStorageDirectory().toString() + "/Movies/showroomVideo/" );
        //listFiles = videoDirectory.listFiles();
        //File randomVideo = (Objects.requireNonNull(listFiles)[1]);
        //Uri videoUri = Uri.fromFile(randomVideo);

        String videoPath = Environment.getExternalStorageDirectory().toString() + "/Movies/showroomVideo/loopVideo.mp4";

        // Declaring and finding videoView
        VideoView videoView = mainView.findViewById(R.id.videoView);
        // Setting video source
        //videoView.setVideoURI(Uri.parse(String.valueOf(videoUri)));
        videoView.setVideoPath(videoPath);
        // Creating a media controller object
        MediaController mediaController = new MediaController(getActivity());
        videoView.setOnPreparedListener(mediaPlayer -> {
            mediaController.setAnchorView(videoView);
            mediaController.setVisibility(View.GONE);
            mediaPlayer.setLooping(true);
            mediaPlayer.setVolume(0,0);
            videoView.setMediaController(mediaController);
            videoView.start();
        });
        return mainView;
    }

    @Override
    public void onDetectionStateChanged(int state) {
        if (state == OnDetectionStateChangedListener.DETECTED) {
            Toast.makeText(requireActivity(), "VIDEO Yay I can see you!", Toast.LENGTH_SHORT).show();
            robot.removeOnDetectionStateChangedListener(this);
            showMenu();
        }
    }

    private void showMenu() {
        Fragment fragment = new MenuFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}