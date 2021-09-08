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

public class Count10 extends AppCompatActivity {

    VideoView videoViewC10;
    String videoPathC10;
    Uri uriC10;
    ImageButton backbtnC10,nextbtnC10;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count10);

        videoViewC10 = findViewById(R.id.videoC10);
        backbtnC10 = findViewById(R.id.btnbackC10);
        nextbtnC10 = findViewById(R.id.nextbtnC10);

        videoPathC10 = "android.resource://" + getPackageName() + "/" + R.raw.count10;
        uriC10 = Uri.parse(videoPathC10);
        videoViewC10.setVideoURI(uriC10);

        mediaController = new MediaController(this);
        videoViewC10.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC10);

        videoViewC10.start();

        videoViewC10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count10.this, Count11.class));

            }
        });

        backbtnC10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count10.this,Count9.class));

            }
        });

        nextbtnC10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count10.this, Count11.class));

            }
        });
    }
}