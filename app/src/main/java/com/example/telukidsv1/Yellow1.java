package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Yellow1 extends AppCompatActivity {

    VideoView videoViewYDPG1;
    String videoPathYDPG1;
    Uri uriYDPG1;
    ImageButton backbtnYDPG1,nextbtnYDPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow1);

        videoViewYDPG1 = findViewById(R.id.videoYDPG1);
        backbtnYDPG1 = findViewById(R.id.btnbackYDPG1);
        nextbtnYDPG1 = findViewById(R.id.nextbtnYDPG1);

        videoPathYDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow1;
        uriYDPG1 = Uri.parse(videoPathYDPG1);
        videoViewYDPG1.setVideoURI(uriYDPG1);

        mediaController = new MediaController(this);
        videoViewYDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYDPG1);

        videoViewYDPG1.start();

        videoViewYDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Yellow1.this, Yellow2.class));

            }
        });

        backbtnYDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow1.this,Blue6.class));

            }
        });

        nextbtnYDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow1.this, Yellow2.class));

            }
        });
    }
}