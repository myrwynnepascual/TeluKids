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

public class Orange3 extends AppCompatActivity {

    VideoView videoViewORPG3;
    String videoPathORPG3;
    Uri uriORPG3;
    ImageButton backbtnORPG3,nextbtnORPG3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange3);

        videoViewORPG3 = findViewById(R.id.videoORPG3);
        backbtnORPG3 = findViewById(R.id.btnbackORPG3);
        nextbtnORPG3 = findViewById(R.id.nextbtnORPG3);

        videoPathORPG3 = "android.resource://" + getPackageName() + "/" + R.raw.orange3;
        uriORPG3 = Uri.parse(videoPathORPG3);
        videoViewORPG3.setVideoURI(uriORPG3);

        mediaController = new MediaController(this);
        videoViewORPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewORPG3);

        videoViewORPG3.start();

        videoViewORPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Orange3.this, Orange4.class));

            }
        });

        backbtnORPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange3.this,Orange2.class));

            }
        });

        nextbtnORPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Orange3.this, Orange4.class));

            }
        });
    }
}