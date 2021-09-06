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

public class Orange2 extends AppCompatActivity {

    VideoView videoViewORPG2;
    String videoPathORPG2;
    Uri uriORPG2;
    ImageButton backbtnORPG2,nextbtnORPG2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange2);

        videoViewORPG2 = findViewById(R.id.videoORPG2);
        backbtnORPG2 = findViewById(R.id.btnbackORPG2);
        nextbtnORPG2 = findViewById(R.id.nextbtnORPG2);

        videoPathORPG2 = "android.resource://" + getPackageName() + "/" + R.raw.orange2;
        uriORPG2 = Uri.parse(videoPathORPG2);
        videoViewORPG2.setVideoURI(uriORPG2);

        mediaController = new MediaController(this);
        videoViewORPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewORPG2);

        videoViewORPG2.start();

        videoViewORPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Orange2.this, Orange3.class));

            }
        });

        backbtnORPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange2.this,Orange1.class));

            }
        });

        nextbtnORPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange2.this, Orange3.class));

            }
        });
    }
}