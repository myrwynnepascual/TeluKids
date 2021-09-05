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

public class Blue6 extends AppCompatActivity {

    VideoView videoViewBDPG6;
    String videoPathBDPG6;
    Uri uriBDPG6;
    ImageButton backbtnBDPG6,nextbtnBDPG6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue6);

        videoViewBDPG6 = findViewById(R.id.videoBDPG6);
        backbtnBDPG6 = findViewById(R.id.btnbackBDPG6);
        nextbtnBDPG6 = findViewById(R.id.nextbtnBDPG6);

        videoPathBDPG6 = "android.resource://" + getPackageName() + "/" + R.raw.blue6;
        uriBDPG6 = Uri.parse(videoPathBDPG6);
        videoViewBDPG6.setVideoURI(uriBDPG6);

        mediaController = new MediaController(this);
        videoViewBDPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewBDPG6);

        videoViewBDPG6.start();

        videoViewBDPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Blue6.this, Yellow1.class));

            }
        });

        backbtnBDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue6.this,Blue5.class));

            }
        });

        nextbtnBDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue6.this, Yellow1.class));

            }
        });
    }
}