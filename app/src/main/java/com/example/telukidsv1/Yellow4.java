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

public class Yellow4 extends AppCompatActivity {

    VideoView videoViewYDPG4;
    String videoPathYDPG4;
    Uri uriYDPG4;
    ImageButton backbtnYDPG4,nextbtnYDPG4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow4);

        videoViewYDPG4 = findViewById(R.id.videoYDPG4);
        backbtnYDPG4 = findViewById(R.id.btnbackYDPG4);
        nextbtnYDPG4 = findViewById(R.id.nextbtnYDPG4);

        videoPathYDPG4 = "android.resource://" + getPackageName() + "/" + R.raw.yellow4;
        uriYDPG4 = Uri.parse(videoPathYDPG4);
        videoViewYDPG4.setVideoURI(uriYDPG4);

        mediaController = new MediaController(this);
        videoViewYDPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYDPG4);

        videoViewYDPG4.start();

        videoViewYDPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Yellow4.this, Yellow5.class));

            }
        });

        backbtnYDPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow4.this,Yellow3.class));

            }
        });

        nextbtnYDPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow4.this, Yellow5.class));

            }
        });
    }
}