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

public class Red5 extends AppCompatActivity {

    VideoView videoViewRDPG5;
    String videoPathRDPG5;
    Uri uriRDPG5;
    ImageButton backbtnRDPG5,nextbtnRDPG5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red5);

        videoViewRDPG5 = findViewById(R.id.videoRDPG5);
        backbtnRDPG5 = findViewById(R.id.btnbackRDPG5);
        nextbtnRDPG5 = findViewById(R.id.nextbtnRDPG5);

        videoPathRDPG5 = "android.resource://" + getPackageName() + "/" + R.raw.red5;
        uriRDPG5 = Uri.parse(videoPathRDPG5);
        videoViewRDPG5.setVideoURI(uriRDPG5);

        mediaController = new MediaController(this);
        videoViewRDPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG5);

        videoViewRDPG5.start();

        videoViewRDPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Red5.this, Red6.class));

            }
        });

        backbtnRDPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red5.this,Red4.class));

            }
        });

        nextbtnRDPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red5.this, Red6.class));

            }
        });
    }
}