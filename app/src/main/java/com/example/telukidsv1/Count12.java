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

public class Count12 extends AppCompatActivity {

    VideoView videoViewC12;
    String videoPathC12;
    Uri uriC12;
    ImageButton backbtnC12,nextbtnC12;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count12);

        videoViewC12 = findViewById(R.id.videoC12);
        backbtnC12 = findViewById(R.id.btnbackC12);
        nextbtnC12 = findViewById(R.id.nextbtnC12);

        videoPathC12 = "android.resource://" + getPackageName() + "/" + R.raw.count12;
        uriC12 = Uri.parse(videoPathC12);
        videoViewC12.setVideoURI(uriC12);

        mediaController = new MediaController(this);
        videoViewC12.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC12);

        videoViewC12.start();

        videoViewC12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count12.this, Count13.class));

            }
        });

        backbtnC12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count12.this,Count11.class));

            }
        });

        nextbtnC12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count12.this, Count13.class));

            }
        });
    }
}