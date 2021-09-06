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

public class Orange1 extends AppCompatActivity {

    VideoView videoViewORPG1;
    String videoPathORPG1;
    Uri uriORPG1;
    ImageButton backbtnORPG1,nextbtnORPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange1);

        videoViewORPG1 = findViewById(R.id.videoORPG1);
        backbtnORPG1 = findViewById(R.id.btnbackORPG1);
        nextbtnORPG1 = findViewById(R.id.nextbtnORPG1);

        videoPathORPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange1;
        uriORPG1 = Uri.parse(videoPathORPG1);
        videoViewORPG1.setVideoURI(uriORPG1);

        mediaController = new MediaController(this);
        videoViewORPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewORPG1);

        videoViewORPG1.start();

        videoViewORPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Orange1.this, Orange2.class));

            }
        });

        backbtnORPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange1.this,Yellow6.class));

            }
        });

        nextbtnORPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange1.this, Orange2.class));

            }
        });
    }
}