package com.apps.romain.timer;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Multiplayer extends AppCompatActivity {
    private int i = 0;
    private Handler customHandler = new Handler();
    private Button playButton;
    private Button startButton;
    TextView firstPlayer;
    TextView secondPlayer;
    TextView thirdPlayer;
    TextView humanPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer);

        playButton = (Button) findViewById(R.id.playBtn);
        startButton = (Button) findViewById(R.id.startBtn);
        firstPlayer = (TextView) findViewById(R.id.first);
        secondPlayer = (TextView) findViewById(R.id.second);
        thirdPlayer = (TextView) findViewById(R.id.third);
        humanPlayer = (TextView) findViewById(R.id.human);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRobot();
                startButton.setEnabled(false);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanPlayer.setText(""+i);
                i++;
                playRobot();
            }
        });
        playButton.setEnabled(false);
    }

    private void playRobot() {
        customHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                firstPlayer.setText(""+i);
                playButton.setEnabled(false);
            }
        }, 0);
        customHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                secondPlayer.setText(""+i);
            }
        }, 1000);
        customHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                thirdPlayer.setText("" + i);
                playButton.setEnabled(true);
            }
        }, 2000);
    }
}
