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

public class Red3 extends AppCompatActivity {

    VideoView videoViewRDPG3;
    String videoPathRDPG3;
    Uri uriRDPG3;
    ImageButton backbtnRDPG3,nextbtnRDPG3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red3);

        videoViewRDPG3 = findViewById(R.id.videoRDPG3);
        backbtnRDPG3 = findViewById(R.id.btnbackRDPG3);
        nextbtnRDPG3 = findViewById(R.id.nextbtnRDPG3);

        videoPathRDPG3 = "android.resource://" + getPackageName() + "/" + R.raw.red3;
        uriRDPG3 = Uri.parse(videoPathRDPG3);
        videoViewRDPG3.setVideoURI(uriRDPG3);

        mediaController = new MediaController(this);
        videoViewRDPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG3);

        videoViewRDPG3.start();

        videoViewRDPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Red3.this, Red4.class));

            }
        });

        backbtnRDPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red3.this,Red2.class));

            }
        });

        nextbtnRDPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red3.this, Red4.class));

            }
        });
    }
}