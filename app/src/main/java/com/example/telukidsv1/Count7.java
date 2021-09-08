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

public class Count7 extends AppCompatActivity {

    VideoView videoViewC7;
    String videoPathC7;
    Uri uriC7;
    ImageButton backbtnC7,nextbtnC7;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count7);

        videoViewC7 = findViewById(R.id.videoC7);
        backbtnC7 = findViewById(R.id.btnbackC7);
        nextbtnC7 = findViewById(R.id.nextbtnC7);

        videoPathC7 = "android.resource://" + getPackageName() + "/" + R.raw.count7;
        uriC7 = Uri.parse(videoPathC7);
        videoViewC7.setVideoURI(uriC7);

        mediaController = new MediaController(this);
        videoViewC7.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC7);

        videoViewC7.start();

        videoViewC7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count7.this, Count8.class));

            }
        });

        backbtnC7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count7.this,Count6.class));

            }
        });

        nextbtnC7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count7.this, Count8.class));

            }
        });
    }
}