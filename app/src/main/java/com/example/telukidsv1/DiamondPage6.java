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
import android.widget.VideoView;

public class DiamondPage6 extends AppCompatActivity {

    VideoView videoViewDPG6;
    String videoPathDPG6;
    Uri uriDPG6;
    ImageButton backbtnDPG6,nextDPG6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_page6);

        videoViewDPG6 = findViewById(R.id.videoDPG6);
        backbtnDPG6 = findViewById(R.id.btnbackDPG6);
        nextDPG6 = findViewById(R.id.nextbtnDPG6);

        videoPathDPG6 = "android.resource://" + getPackageName() + "/" + R.raw.diamond6;
        uriDPG6 = Uri.parse(videoPathDPG6);
        videoViewDPG6.setVideoURI(uriDPG6);

        MediaController mediaController= new MediaController(this);
        videoViewDPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewDPG6);

        videoViewDPG6.start();

        videoViewDPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(DiamondPage6.this, ShapesLessonCongrats.class));

            }
        });

        backbtnDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DiamondPage6.this,DiamondPage5.class));

            }
        });

        nextDPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DiamondPage6.this, ShapesLessonCongrats.class));

            }
        });
    }
}