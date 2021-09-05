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

public class Blue2 extends AppCompatActivity {

    VideoView videoViewBDPG2;
    String videoPathBDPG2;
    Uri uriBDPG2;
    ImageButton backbtnBDPG2,nextbtnBDPG2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue2);

        videoViewBDPG2 = findViewById(R.id.videoBDPG2);
        backbtnBDPG2 = findViewById(R.id.btnbackBDPG2);
        nextbtnBDPG2 = findViewById(R.id.nextbtnBDPG2);

        videoPathBDPG2 = "android.resource://" + getPackageName() + "/" + R.raw.blue2;
        uriBDPG2 = Uri.parse(videoPathBDPG2);
        videoViewBDPG2.setVideoURI(uriBDPG2);

        mediaController = new MediaController(this);
        videoViewBDPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewBDPG2);

        videoViewBDPG2.start();

        videoViewBDPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Blue2.this, Blue3.class));

            }
        });

        backbtnBDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue2.this,Blue1.class));

            }
        });

        nextbtnBDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue2.this, Blue3.class));

            }
        });
    }
}