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

public class Count14 extends AppCompatActivity {

    VideoView videoViewC14;
    String videoPathC14;
    Uri uriC14;
    ImageButton backbtnC14,nextbtnC14;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count14);

        videoViewC14 = findViewById(R.id.videoC14);
        backbtnC14 = findViewById(R.id.btnbackC14);
        nextbtnC14 = findViewById(R.id.nextbtnC14);

        videoPathC14 = "android.resource://" + getPackageName() + "/" + R.raw.count14;
        uriC14 = Uri.parse(videoPathC14);
        videoViewC14.setVideoURI(uriC14);

        mediaController = new MediaController(this);
        videoViewC14.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC14);

        videoViewC14.start();

        videoViewC14.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count14.this, Count15.class));

            }
        });

        backbtnC14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count14.this,Count13.class));

            }
        });

        nextbtnC14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count14.this, Count15.class));

            }
        });
    }
}