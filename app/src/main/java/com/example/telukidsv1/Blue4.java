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

public class Blue4 extends AppCompatActivity {

    VideoView videoViewBDPG4;
    String videoPathBDPG4;
    Uri uriBDPG4;
    ImageButton backbtnBDPG4,nextbtnBDPG4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue4);

        videoViewBDPG4 = findViewById(R.id.videoBDPG4);
        backbtnBDPG4 = findViewById(R.id.btnbackBDPG4);
        nextbtnBDPG4 = findViewById(R.id.nextbtnBDPG4);

        videoPathBDPG4 = "android.resource://" + getPackageName() + "/" + R.raw.blue4;
        uriBDPG4 = Uri.parse(videoPathBDPG4);
        videoViewBDPG4.setVideoURI(uriBDPG4);

        mediaController = new MediaController(this);
        videoViewBDPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewBDPG4);

        videoViewBDPG4.start();

        videoViewBDPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Blue4.this, Blue5.class));

            }
        });

        backbtnBDPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue4.this,Blue3.class));

            }
        });

        nextbtnBDPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue4.this, Blue5.class));

            }
        });
    }
}