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

public class Count16 extends AppCompatActivity {

    VideoView videoViewC16;
    String videoPathC16;
    Uri uriC16;
    ImageButton backbtnC16,nextbtnC16;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count16);

        videoViewC16 = findViewById(R.id.videoC16);
        backbtnC16 = findViewById(R.id.btnbackC16);
        nextbtnC16 = findViewById(R.id.nextbtnC16);

        videoPathC16 = "android.resource://" + getPackageName() + "/" + R.raw.count16;
        uriC16 = Uri.parse(videoPathC16);
        videoViewC16.setVideoURI(uriC16);

        mediaController = new MediaController(this);
        videoViewC16.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC16);

        videoViewC16.start();

        videoViewC16.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count16.this, Count17.class));

            }
        });

        backbtnC16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count16.this,Count15.class));

            }
        });

        nextbtnC16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count16.this, Count17.class));

            }
        });
    }
}