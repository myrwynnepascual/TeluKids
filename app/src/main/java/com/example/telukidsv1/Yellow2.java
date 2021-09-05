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

public class Yellow2 extends AppCompatActivity {

    VideoView videoViewYDPG2;
    String videoPathYDPG2;
    Uri uriYDPG2;
    ImageButton backbtnYDPG2,nextbtnYDPG2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow2);

        videoViewYDPG2 = findViewById(R.id.videoYDPG2);
        backbtnYDPG2 = findViewById(R.id.btnbackYDPG2);
        nextbtnYDPG2 = findViewById(R.id.nextbtnYDPG2);

        videoPathYDPG2 = "android.resource://" + getPackageName() + "/" + R.raw.yellow2;
        uriYDPG2 = Uri.parse(videoPathYDPG2);
        videoViewYDPG2.setVideoURI(uriYDPG2);

        mediaController = new MediaController(this);
        videoViewYDPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYDPG2);

        videoViewYDPG2.start();

        videoViewYDPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Yellow2.this, Yellow3.class));

            }
        });

        backbtnYDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow2.this,Yellow1.class));

            }
        });

        nextbtnYDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow2.this, Yellow3.class));

            }
        });
    }
}