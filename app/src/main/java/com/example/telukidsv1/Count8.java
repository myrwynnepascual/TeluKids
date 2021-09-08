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

public class Count8 extends AppCompatActivity {

    VideoView videoViewC8;
    String videoPathC8;
    Uri uriC8;
    ImageButton backbtnC8,nextbtnC8;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count8);

        videoViewC8 = findViewById(R.id.videoC8);
        backbtnC8 = findViewById(R.id.btnbackC8);
        nextbtnC8 = findViewById(R.id.nextbtnC8);

        videoPathC8 = "android.resource://" + getPackageName() + "/" + R.raw.count8;
        uriC8 = Uri.parse(videoPathC8);
        videoViewC8.setVideoURI(uriC8);

        mediaController = new MediaController(this);
        videoViewC8.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC8);

        videoViewC8.start();

        videoViewC8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count8.this, Count9 .class));

            }
        });

        backbtnC8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count8.this,Count7.class));

            }
        });

        nextbtnC8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count8.this, Count9.class));

            }
        });
    }
}