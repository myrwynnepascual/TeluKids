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

public class Count2 extends AppCompatActivity {

    VideoView videoViewC2;
    String videoPathC2;
    Uri uriC2;
    ImageButton backbtnC2,nextbtnC2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count2);

        videoViewC2 = findViewById(R.id.videoC2);
        backbtnC2 = findViewById(R.id.btnbackC2);
        nextbtnC2 = findViewById(R.id.nextbtnC2);

        videoPathC2 = "android.resource://" + getPackageName() + "/" + R.raw.count2;
        uriC2 = Uri.parse(videoPathC2);
        videoViewC2.setVideoURI(uriC2);

        mediaController = new MediaController(this);
        videoViewC2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC2);

        videoViewC2.start();

        videoViewC2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count2.this, Count3 .class));

            }
        });

        backbtnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count2.this,Count1.class));

            }
        });

        nextbtnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count2.this, Count3.class));

            }
        });
    }
}