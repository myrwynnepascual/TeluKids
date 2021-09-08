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

public class Count15 extends AppCompatActivity {

    VideoView videoViewC15;
    String videoPathC15;
    Uri uriC15;
    ImageButton backbtnC15,nextbtnC15;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count15);

        videoViewC15 = findViewById(R.id.videoC15);
        backbtnC15 = findViewById(R.id.btnbackC15);
        nextbtnC15 = findViewById(R.id.nextbtnC15);

        videoPathC15 = "android.resource://" + getPackageName() + "/" + R.raw.count15;
        uriC15 = Uri.parse(videoPathC15);
        videoViewC15.setVideoURI(uriC15);

        mediaController = new MediaController(this);
        videoViewC15.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC15);

        videoViewC15.start();

        videoViewC15.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count15.this, Count16.class));

            }
        });

        backbtnC15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count15.this,Count14.class));

            }
        });

        nextbtnC15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count15.this, Count16.class));

            }
        });
    }
}