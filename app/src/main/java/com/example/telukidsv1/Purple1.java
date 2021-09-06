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

public class Purple1 extends AppCompatActivity {

    VideoView videoViewPUPG1;
    String videoPathPUPG1;
    Uri uriPUPG1;
    ImageButton backbtnPUPG1,nextbtnPUPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple1);

        videoViewPUPG1 = findViewById(R.id.videoPUPG1);
        backbtnPUPG1 = findViewById(R.id.btnbackPUPG1);
        nextbtnPUPG1 = findViewById(R.id.nextbtnPUPG1);

        videoPathPUPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple1;
        uriPUPG1 = Uri.parse(videoPathPUPG1);
        videoViewPUPG1.setVideoURI(uriPUPG1);

        mediaController = new MediaController(this);
        videoViewPUPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewPUPG1);

        videoViewPUPG1.start();

        videoViewPUPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Purple1.this, Purple2.class));

            }
        });

        backbtnPUPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple1.this,Orange6.class));

            }
        });

        nextbtnPUPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple1.this, Purple2.class));

            }
        });
    }
}