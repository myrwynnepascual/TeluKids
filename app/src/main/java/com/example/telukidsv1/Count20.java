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

public class Count20 extends AppCompatActivity {

    VideoView videoViewC20;
    String videoPathC20;
    Uri uriC20;
    ImageButton backbtnC20,nextbtnC20;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count20);

        videoViewC20 = findViewById(R.id.videoC20);
        backbtnC20 = findViewById(R.id.btnbackC20);
        nextbtnC20 = findViewById(R.id.nextbtnC20);

        videoPathC20 = "android.resource://" + getPackageName() + "/" + R.raw.count20;
        uriC20 = Uri.parse(videoPathC20);
        videoViewC20.setVideoURI(uriC20);

        mediaController = new MediaController(this);
        videoViewC20.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC20);

        videoViewC20.start();

        videoViewC20.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count20.this, CountingLessonCongrats.class));

            }
        });

        backbtnC20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count20.this,Count19.class));

            }
        });

        nextbtnC20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count20.this, CountingLessonCongrats.class));

            }
        });
    }
}