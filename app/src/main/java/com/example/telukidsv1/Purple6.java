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

public class Purple6 extends AppCompatActivity {

    VideoView videoViewPUPG6;
    String videoPathPUPG6;
    Uri uriPUPG6;
    ImageButton backbtnPUPG6,nextbtnPUPG6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple6);

        videoViewPUPG6 = findViewById(R.id.videoPUPG6);
        backbtnPUPG6 = findViewById(R.id.btnbackPUPG6);
        nextbtnPUPG6 = findViewById(R.id.nextbtnPUPG6);

        videoPathPUPG6 = "android.resource://" + getPackageName() + "/" + R.raw.purple6;
        uriPUPG6 = Uri.parse(videoPathPUPG6);
        videoViewPUPG6.setVideoURI(uriPUPG6);

        mediaController = new MediaController(this);
        videoViewPUPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewPUPG6);

        videoViewPUPG6.start();

        videoViewPUPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Purple6.this, Green1.class));

            }
        });

        backbtnPUPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple6.this,Purple5.class));

            }
        });

        nextbtnPUPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple6.this, Green1.class));

            }
        });
    }
}