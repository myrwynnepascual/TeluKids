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

public class Count3 extends AppCompatActivity {

    VideoView videoViewC3;
    String videoPathC3;
    Uri uriC3;
    ImageButton backbtnC3,nextbtnC3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count3);

        videoViewC3 = findViewById(R.id.videoC3);
        backbtnC3 = findViewById(R.id.btnbackC3);
        nextbtnC3 = findViewById(R.id.nextbtnC3);

        videoPathC3 = "android.resource://" + getPackageName() + "/" + R.raw.count3;
        uriC3 = Uri.parse(videoPathC3);
        videoViewC3.setVideoURI(uriC3);

        mediaController = new MediaController(this);
        videoViewC3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC3);

        videoViewC3.start();

        videoViewC3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count3.this, Count4 .class));

            }
        });

        backbtnC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count3.this,Count2.class));

            }
        });

        nextbtnC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count3.this, Count4.class));

            }
        });
    }
}