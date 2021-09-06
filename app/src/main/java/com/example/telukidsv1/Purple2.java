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

public class Purple2 extends AppCompatActivity {

    VideoView videoViewPUPG2;
    String videoPathPUPG2;
    Uri uriPUPG2;
    ImageButton backbtnPUPG2,nextbtnPUPG2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple2);

        videoViewPUPG2 = findViewById(R.id.videoPUPG2);
        backbtnPUPG2 = findViewById(R.id.btnbackPUPG2);
        nextbtnPUPG2 = findViewById(R.id.nextbtnPUPG2);

        videoPathPUPG2 = "android.resource://" + getPackageName() + "/" + R.raw.purple2;
        uriPUPG2 = Uri.parse(videoPathPUPG2);
        videoViewPUPG2.setVideoURI(uriPUPG2);

        mediaController = new MediaController(this);
        videoViewPUPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewPUPG2);

        videoViewPUPG2.start();

        videoViewPUPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Purple2.this, Purple3.class));

            }
        });

        backbtnPUPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple2.this,Purple1.class));

            }
        });

        nextbtnPUPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple2.this, Purple3.class));

            }
        });
    }
}