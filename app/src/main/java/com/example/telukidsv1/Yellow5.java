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

public class Yellow5 extends AppCompatActivity {

    VideoView videoViewYDPG5;
    String videoPathYDPG5;
    Uri uriYDPG5;
    ImageButton backbtnYDPG5,nextbtnYDPG5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow5);

        videoViewYDPG5 = findViewById(R.id.videoYDPG5);
        backbtnYDPG5 = findViewById(R.id.btnbackYDPG5);
        nextbtnYDPG5 = findViewById(R.id.nextbtnYDPG5);

        videoPathYDPG5 = "android.resource://" + getPackageName() + "/" + R.raw.yellow5;
        uriYDPG5 = Uri.parse(videoPathYDPG5);
        videoViewYDPG5.setVideoURI(uriYDPG5);

        mediaController = new MediaController(this);
        videoViewYDPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYDPG5);

        videoViewYDPG5.start();

        videoViewYDPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Yellow5.this, Yellow6.class));

            }
        });

        backbtnYDPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow5.this,Yellow4.class));

            }
        });

        nextbtnYDPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow5.this, Yellow6.class));

            }
        });
    }
}