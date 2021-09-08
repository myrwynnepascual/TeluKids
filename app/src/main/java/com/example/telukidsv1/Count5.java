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

public class Count5 extends AppCompatActivity {

    VideoView videoViewC5;
    String videoPathC5;
    Uri uriC5;
    ImageButton backbtnC5,nextbtnC5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count5);

        videoViewC5 = findViewById(R.id.videoC5);
        backbtnC5 = findViewById(R.id.btnbackC5);
        nextbtnC5 = findViewById(R.id.nextbtnC5);

        videoPathC5 = "android.resource://" + getPackageName() + "/" + R.raw.count5;
        uriC5 = Uri.parse(videoPathC5);
        videoViewC5.setVideoURI(uriC5);

        mediaController = new MediaController(this);
        videoViewC5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC5);

        videoViewC5.start();

        videoViewC5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count5.this, Count6 .class));

            }
        });

        backbtnC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count5.this,Count4.class));

            }
        });

        nextbtnC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count5.this, Count6.class));

            }
        });
    }
}