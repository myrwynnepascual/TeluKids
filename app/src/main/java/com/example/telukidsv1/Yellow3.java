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

public class Yellow3 extends AppCompatActivity {

    VideoView videoViewYDPG3;
    String videoPathYDPG3;
    Uri uriYDPG3;
    ImageButton backbtnYDPG3,nextbtnYDPG3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow3);

        videoViewYDPG3 = findViewById(R.id.videoYDPG3);
        backbtnYDPG3 = findViewById(R.id.btnbackYDPG3);
        nextbtnYDPG3 = findViewById(R.id.nextbtnYDPG3);

        videoPathYDPG3 = "android.resource://" + getPackageName() + "/" + R.raw.yellow3;
        uriYDPG3 = Uri.parse(videoPathYDPG3);
        videoViewYDPG3.setVideoURI(uriYDPG3);

        mediaController = new MediaController(this);
        videoViewYDPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYDPG3);

        videoViewYDPG3.start();

        videoViewYDPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Yellow3.this, Yellow4.class));

            }
        });

        backbtnYDPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow3.this,Yellow2.class));

            }
        });

        nextbtnYDPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow3.this, Yellow4.class));

            }
        });
    }
}