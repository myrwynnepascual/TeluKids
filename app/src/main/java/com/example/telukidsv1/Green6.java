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

public class Green6 extends AppCompatActivity {

    VideoView videoViewGRPG6;
    String videoPathGRPG6;
    Uri uriGRPG6;
    ImageButton backbtnGRPG6,nextbtnGRPG6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green6);

        videoViewGRPG6 = findViewById(R.id.videoGRPG6);
        backbtnGRPG6 = findViewById(R.id.btnbackGRPG6);
        nextbtnGRPG6 = findViewById(R.id.nextbtnGRPG6);

        videoPathGRPG6 = "android.resource://" + getPackageName() + "/" + R.raw.green6;
        uriGRPG6 = Uri.parse(videoPathGRPG6);
        videoViewGRPG6.setVideoURI(uriGRPG6);

        mediaController = new MediaController(this);
        videoViewGRPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewGRPG6);

        videoViewGRPG6.start();

        videoViewGRPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Green6.this, ColorsLessonCongrats.class));

            }
        });

        backbtnGRPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green6.this,Purple1.class));

            }
        });

        nextbtnGRPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green6.this, ColorsLessonCongrats.class));

            }
        });
    }
}