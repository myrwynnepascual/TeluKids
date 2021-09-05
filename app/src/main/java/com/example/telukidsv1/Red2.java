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

public class Red2 extends AppCompatActivity {

    VideoView videoViewRDPG2;
    String videoPathRDPG2;
    Uri uriRDPG2;
    ImageButton backbtnRDPG2,nextbtnRDPG2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red2);

        videoViewRDPG2 = findViewById(R.id.videoRDPG2);
        backbtnRDPG2 = findViewById(R.id.btnbackRDPG2);
        nextbtnRDPG2 = findViewById(R.id.nextbtnRDPG2);

        videoPathRDPG2 = "android.resource://" + getPackageName() + "/" + R.raw.red2;
        uriRDPG2 = Uri.parse(videoPathRDPG2);
        videoViewRDPG2.setVideoURI(uriRDPG2);

        mediaController = new MediaController(this);
        videoViewRDPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG2);

        videoViewRDPG2.start();

        videoViewRDPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Red2.this, Red3.class));

            }
        });

        backbtnRDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red2.this,Red1.class));

            }
        });

        nextbtnRDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red2.this, Red3.class));

            }
        });
    }
}