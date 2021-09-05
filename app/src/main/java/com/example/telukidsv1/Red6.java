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

public class Red6 extends AppCompatActivity {

    VideoView videoViewRDPG6;
    String videoPathRDPG6;
    Uri uriRDPG6;
    ImageButton backbtnRDPG6,nextbtnRDPG6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red6);

        videoViewRDPG6 = findViewById(R.id.videoRDPG6);
        backbtnRDPG6 = findViewById(R.id.btnbackRDPG6);
        nextbtnRDPG6 = findViewById(R.id.nextbtnRDPG6);

        videoPathRDPG6 = "android.resource://" + getPackageName() + "/" + R.raw.red6;
        uriRDPG6 = Uri.parse(videoPathRDPG6);
        videoViewRDPG6.setVideoURI(uriRDPG6);

        mediaController = new MediaController(this);
        videoViewRDPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG6);

        videoViewRDPG6.start();

        videoViewRDPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Red6.this, Blue1.class));

            }
        });

        backbtnRDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red6.this,Red5.class));

            }
        });

        nextbtnRDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red6.this, Blue1.class));

            }
        });
    }
}