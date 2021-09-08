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

public class Count4 extends AppCompatActivity {

    VideoView videoViewC4;
    String videoPathC4;
    Uri uriC4;
    ImageButton backbtnC4,nextbtnC4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count4);

        videoViewC4 = findViewById(R.id.videoC4);
        backbtnC4 = findViewById(R.id.btnbackC4);
        nextbtnC4 = findViewById(R.id.nextbtnC4);

        videoPathC4 = "android.resource://" + getPackageName() + "/" + R.raw.count4;
        uriC4 = Uri.parse(videoPathC4);
        videoViewC4.setVideoURI(uriC4);

        mediaController = new MediaController(this);
        videoViewC4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC4);

        videoViewC4.start();

        videoViewC4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count4.this, Count5 .class));

            }
        });

        backbtnC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count4.this,Count3.class));

            }
        });

        nextbtnC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count4.this, Count5.class));

            }
        });
    }
}