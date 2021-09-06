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

public class Purple4 extends AppCompatActivity {

    VideoView videoViewPUPG4;
    String videoPathPUPG4;
    Uri uriPUPG4;
    ImageButton backbtnPUPG4,nextbtnPUPG4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple4);

        videoViewPUPG4 = findViewById(R.id.videoPUPG4);
        backbtnPUPG4 = findViewById(R.id.btnbackPUPG4);
        nextbtnPUPG4 = findViewById(R.id.nextbtnPUPG4);

        videoPathPUPG4 = "android.resource://" + getPackageName() + "/" + R.raw.purple4;
        uriPUPG4 = Uri.parse(videoPathPUPG4);
        videoViewPUPG4.setVideoURI(uriPUPG4);

        mediaController = new MediaController(this);
        videoViewPUPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewPUPG4);

        videoViewPUPG4.start();

        videoViewPUPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Purple4.this, Purple5.class));

            }
        });

        backbtnPUPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple4.this,Purple3.class));

            }
        });

        nextbtnPUPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple4.this, Purple5.class));

            }
        });
    }
}