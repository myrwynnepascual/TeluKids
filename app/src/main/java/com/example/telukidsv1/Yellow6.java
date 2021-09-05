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

public class Yellow6 extends AppCompatActivity {

    VideoView videoViewYDPG6;
    String videoPathYDPG6;
    Uri uriYDPG6;
    ImageButton backbtnYDPG6,nextbtnYDPG6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow6);

        videoViewYDPG6 = findViewById(R.id.videoYDPG6);
        backbtnYDPG6 = findViewById(R.id.btnbackYDPG6);
        nextbtnYDPG6 = findViewById(R.id.nextbtnYDPG6);

        videoPathYDPG6 = "android.resource://" + getPackageName() + "/" + R.raw.yellow6;
        uriYDPG6 = Uri.parse(videoPathYDPG6);
        videoViewYDPG6.setVideoURI(uriYDPG6);

        mediaController = new MediaController(this);
        videoViewYDPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYDPG6);

        videoViewYDPG6.start();

        videoViewYDPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                //startActivity(new Intent(Yellow6.this, Orange1.class));

            }
        });

        backbtnYDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow6.this,Yellow5.class));

            }
        });

        nextbtnYDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Yellow6.this, Orange1.class));

            }
        });
    }
}