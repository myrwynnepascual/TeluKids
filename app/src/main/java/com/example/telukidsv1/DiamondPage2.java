package com.example.telukidsv1;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DiamondPage2 extends AppCompatActivity {

    VideoView videoViewDPG2;
    String videoPathDPG2;
    Uri uriDPG2;
    ImageButton backbtnDPG2,nextDPG2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_page2);

        videoViewDPG2 = findViewById(R.id.videoDPG2);
        backbtnDPG2 = findViewById(R.id.btnbackDPG2);
        nextDPG2 = findViewById(R.id.nextbtnDPG2);

        videoPathDPG2 = "android.resource://" + getPackageName() + "/" + R.raw.diamond2;
        uriDPG2 = Uri.parse(videoPathDPG2);
        videoViewDPG2.setVideoURI(uriDPG2);

        MediaController mediaController= new MediaController(this);
        videoViewDPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewDPG2);

        videoViewDPG2.start();

        videoViewDPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(DiamondPage2.this, DiamondPage3.class));

            }
        });

        backbtnDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DiamondPage2.this,DiamondPage1.class));

            }
        });

        nextDPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DiamondPage2.this, DiamondPage3.class));

            }
        });
    }
}