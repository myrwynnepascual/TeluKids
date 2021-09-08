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

public class Count9 extends AppCompatActivity {

    VideoView videoViewC9;
    String videoPathC9;
    Uri uriC9;
    ImageButton backbtnC9,nextbtnC9;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count9);

        videoViewC9 = findViewById(R.id.videoC9);
        backbtnC9 = findViewById(R.id.btnbackC9);
        nextbtnC9 = findViewById(R.id.nextbtnC9);

        videoPathC9 = "android.resource://" + getPackageName() + "/" + R.raw.count9;
        uriC9 = Uri.parse(videoPathC9);
        videoViewC9.setVideoURI(uriC9);

        mediaController = new MediaController(this);
        videoViewC9.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC9);

        videoViewC9.start();

        videoViewC9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count9.this, Count10.class));

            }
        });

        backbtnC9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count9.this,Count8.class));

            }
        });

        nextbtnC9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count9.this, Count10.class));

            }
        });
    }
}