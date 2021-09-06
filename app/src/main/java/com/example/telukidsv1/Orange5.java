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

public class Orange5 extends AppCompatActivity {

    VideoView videoViewORPG5;
    String videoPathORPG5;
    Uri uriORPG5;
    ImageButton backbtnORPG5,nextbtnORPG5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange5);

        videoViewORPG5 = findViewById(R.id.videoORPG5);
        backbtnORPG5 = findViewById(R.id.btnbackORPG5);
        nextbtnORPG5 = findViewById(R.id.nextbtnORPG5);

        videoPathORPG5 = "android.resource://" + getPackageName() + "/" + R.raw.orange5;
        uriORPG5 = Uri.parse(videoPathORPG5);
        videoViewORPG5.setVideoURI(uriORPG5);

        mediaController = new MediaController(this);
        videoViewORPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewORPG5);

        videoViewORPG5.start();

        videoViewORPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Orange5.this, Orange6.class));

            }
        });

        backbtnORPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange5.this,Orange4.class));

            }
        });

        nextbtnORPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange5.this, Orange6.class));

            }
        });
    }
}