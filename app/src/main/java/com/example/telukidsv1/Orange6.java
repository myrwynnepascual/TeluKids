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

public class Orange6 extends AppCompatActivity {

    VideoView videoViewORPG6;
    String videoPathORPG6;
    Uri uriORPG6;
    ImageButton backbtnORPG6,nextbtnORPG6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange6);

        videoViewORPG6 = findViewById(R.id.videoORPG6);
        backbtnORPG6 = findViewById(R.id.btnbackORPG6);
        nextbtnORPG6 = findViewById(R.id.nextbtnORPG6);

        videoPathORPG6 = "android.resource://" + getPackageName() + "/" + R.raw.orange6;
        uriORPG6 = Uri.parse(videoPathORPG6);
        videoViewORPG6.setVideoURI(uriORPG6);

        mediaController = new MediaController(this);
        videoViewORPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewORPG6);

        videoViewORPG6.start();

        videoViewORPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Orange6.this, Purple1.class));

            }
        });

        backbtnORPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange6.this,Orange5.class));

            }
        });

        nextbtnORPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange6.this, Purple1.class));

            }
        });
    }
}