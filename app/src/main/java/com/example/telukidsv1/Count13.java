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

public class Count13 extends AppCompatActivity {

    VideoView videoViewC13;
    String videoPathC13;
    Uri uriC13;
    ImageButton backbtnC13,nextbtnC13;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count13);

        videoViewC13 = findViewById(R.id.videoC13);
        backbtnC13 = findViewById(R.id.btnbackC13);
        nextbtnC13 = findViewById(R.id.nextbtnC13);

        videoPathC13 = "android.resource://" + getPackageName() + "/" + R.raw.count13;
        uriC13 = Uri.parse(videoPathC13);
        videoViewC13.setVideoURI(uriC13);

        mediaController = new MediaController(this);
        videoViewC13.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC13);

        videoViewC13.start();

        videoViewC13.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count13.this, Count14.class));

            }
        });

        backbtnC13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count13.this,Count12.class));

            }
        });

        nextbtnC13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count13.this, Count14.class));

            }
        });
    }
}