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

public class Blue5 extends AppCompatActivity {

    VideoView videoViewBDPG5;
    String videoPathBDPG5;
    Uri uriBDPG5;
    ImageButton backbtnBDPG5,nextbtnBDPG5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue5);

        videoViewBDPG5 = findViewById(R.id.videoBDPG5);
        backbtnBDPG5 = findViewById(R.id.btnbackBDPG5);
        nextbtnBDPG5 = findViewById(R.id.nextbtnBDPG5);

        videoPathBDPG5 = "android.resource://" + getPackageName() + "/" + R.raw.blue5;
        uriBDPG5 = Uri.parse(videoPathBDPG5);
        videoViewBDPG5.setVideoURI(uriBDPG5);

        mediaController = new MediaController(this);
        videoViewBDPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewBDPG5);

        videoViewBDPG5.start();

        videoViewBDPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Blue5.this, Blue6.class));

            }
        });

        backbtnBDPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue5.this,Blue4.class));

            }
        });

        nextbtnBDPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue5.this, Blue6.class));

            }
        });
    }
}