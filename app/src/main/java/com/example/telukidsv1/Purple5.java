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

public class Purple5 extends AppCompatActivity {

    VideoView videoViewPUPG5;
    String videoPathPUPG5;
    Uri uriPUPG5;
    ImageButton backbtnPUPG5,nextbtnPUPG5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple5);

        videoViewPUPG5 = findViewById(R.id.videoPUPG5);
        backbtnPUPG5 = findViewById(R.id.btnbackPUPG5);
        nextbtnPUPG5 = findViewById(R.id.nextbtnPUPG5);

        videoPathPUPG5 = "android.resource://" + getPackageName() + "/" + R.raw.purple5;
        uriPUPG5 = Uri.parse(videoPathPUPG5);
        videoViewPUPG5.setVideoURI(uriPUPG5);

        mediaController = new MediaController(this);
        videoViewPUPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewPUPG5);

        videoViewPUPG5.start();

        videoViewPUPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Purple5.this, Purple6.class));

            }
        });

        backbtnPUPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple5.this,Purple4.class));

            }
        });

        nextbtnPUPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple5.this, Purple6.class));

            }
        });
    }
}