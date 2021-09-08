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

public class Count6 extends AppCompatActivity {

    VideoView videoViewC6;
    String videoPathC6;
    Uri uriC6;
    ImageButton backbtnC6,nextbtnC6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count6);

        videoViewC6 = findViewById(R.id.videoC6);
        backbtnC6 = findViewById(R.id.btnbackC6);
        nextbtnC6 = findViewById(R.id.nextbtnC6);

        videoPathC6 = "android.resource://" + getPackageName() + "/" + R.raw.count6;
        uriC6 = Uri.parse(videoPathC6);
        videoViewC6.setVideoURI(uriC6);

        mediaController = new MediaController(this);
        videoViewC6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC6);

        videoViewC6.start();

        videoViewC6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count6.this, Count7 .class));

            }
        });

        backbtnC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count6.this,Count5.class));

            }
        });

        nextbtnC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count6.this, Count7.class));

            }
        });
    }
}