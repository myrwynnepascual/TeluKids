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

public class Orange4 extends AppCompatActivity {

    VideoView videoViewORPG4;
    String videoPathORPG4;
    Uri uriORPG4;
    ImageButton backbtnORPG4,nextbtnORPG4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange4);

        videoViewORPG4 = findViewById(R.id.videoORPG4);
        backbtnORPG4 = findViewById(R.id.btnbackORPG4);
        nextbtnORPG4 = findViewById(R.id.nextbtnORPG4);

        videoPathORPG4 = "android.resource://" + getPackageName() + "/" + R.raw.orange4;
        uriORPG4 = Uri.parse(videoPathORPG4);
        videoViewORPG4.setVideoURI(uriORPG4);

        mediaController = new MediaController(this);
        videoViewORPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewORPG4);

        videoViewORPG4.start();

        videoViewORPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Orange4.this, Orange5.class));

            }
        });

        backbtnORPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange4.this,Orange3.class));

            }
        });

        nextbtnORPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange4.this, Orange5.class));

            }
        });
    }
}