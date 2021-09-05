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

public class Red4 extends AppCompatActivity {

    VideoView videoViewRDPG4;
    String videoPathRDPG4;
    Uri uriRDPG4;
    ImageButton backbtnRDPG4,nextbtnRDPG4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red4);

        videoViewRDPG4 = findViewById(R.id.videoRDPG4);
        backbtnRDPG4 = findViewById(R.id.btnbackRDPG4);
        nextbtnRDPG4 = findViewById(R.id.nextbtnRDPG4);

        videoPathRDPG4 = "android.resource://" + getPackageName() + "/" + R.raw.red4;
        uriRDPG4 = Uri.parse(videoPathRDPG4);
        videoViewRDPG4.setVideoURI(uriRDPG4);

        mediaController = new MediaController(this);
        videoViewRDPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG4);

        videoViewRDPG4.start();

        videoViewRDPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Red4.this, Red5.class));

            }
        });

        backbtnRDPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red4.this,Red3.class));

            }
        });

        nextbtnRDPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red4.this, Red5.class));

            }
        });
    }
}