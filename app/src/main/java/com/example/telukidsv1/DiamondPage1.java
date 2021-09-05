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

public class DiamondPage1 extends AppCompatActivity {

    VideoView videoViewDPG1;
    String videoPathDPG1;
    Uri uriDPG1;
    ImageButton backbtnDPG1,nextDPG1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_page1);

        videoViewDPG1 = findViewById(R.id.videoDPG1);
        backbtnDPG1 = findViewById(R.id.btnbackDPG1);
        nextDPG1 = findViewById(R.id.nextbtnDPG1);

        videoPathDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond1;
        uriDPG1 = Uri.parse(videoPathDPG1);
        videoViewDPG1.setVideoURI(uriDPG1);

        MediaController mediaController= new MediaController(this);
        videoViewDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewDPG1);

        videoViewDPG1.start();

        videoViewDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(DiamondPage1.this, DiamondPage2.class));

            }
        });

        backbtnDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DiamondPage1.this,RectanglePage6.class));

            }
        });

        nextDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DiamondPage1.this, DiamondPage2.class));

            }
        });
    }
}