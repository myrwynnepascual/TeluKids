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

public class Count1 extends AppCompatActivity {

    VideoView videoViewC1;
    String videoPathC1;
    Uri uriC1;
    ImageButton backbtnC1,nextbtnC1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count1);

        videoViewC1 = findViewById(R.id.videoC1);
        backbtnC1 = findViewById(R.id.btnbackC1);
        nextbtnC1 = findViewById(R.id.nextbtnC1);

        videoPathC1 = "android.resource://" + getPackageName() + "/" + R.raw.count1;
        uriC1 = Uri.parse(videoPathC1);
        videoViewC1.setVideoURI(uriC1);

        mediaController = new MediaController(this);
        videoViewC1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC1);

        videoViewC1.start();

        videoViewC1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count1.this, Count2.class));

            }
        });

        backbtnC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count1.this,Countingx.class));

            }
        });

        nextbtnC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count1.this, Count2.class));

            }
        });
    }
}