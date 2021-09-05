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

public class Blue1 extends AppCompatActivity {

    VideoView videoViewBDPG1;
    String videoPathBDPG1;
    Uri uriBDPG1;
    ImageButton backbtnBDPG1,nextbtnBDPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue1);

        videoViewBDPG1 = findViewById(R.id.videoBDPG1);
        backbtnBDPG1 = findViewById(R.id.btnbackBDPG1);
        nextbtnBDPG1 = findViewById(R.id.nextbtnBDPG1);

        videoPathBDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue1;
        uriBDPG1 = Uri.parse(videoPathBDPG1);
        videoViewBDPG1.setVideoURI(uriBDPG1);

        mediaController = new MediaController(this);
        videoViewBDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewBDPG1);

        videoViewBDPG1.start();

        videoViewBDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Blue1.this, Blue2.class));

            }
        });

        backbtnBDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue1.this,Red6.class));

            }
        });

        nextbtnBDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue1.this, Blue2.class));

            }
        });
    }
}