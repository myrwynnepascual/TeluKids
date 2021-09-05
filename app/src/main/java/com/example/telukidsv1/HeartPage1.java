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

public class HeartPage1 extends AppCompatActivity {

    VideoView videoViewHPG1;
    String videoPathHPG1;
    Uri uriHPG1;
    ImageButton backbtnHPG1, nextbtnHPG1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_page1);

        videoViewHPG1 = findViewById(R.id.videoHPG1);
        backbtnHPG1 = findViewById(R.id.btnbackHPG1);
        nextbtnHPG1 = findViewById(R.id.nextbtnHPG1);

        videoPathHPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart1;
        uriHPG1 = Uri.parse(videoPathHPG1);
        videoViewHPG1.setVideoURI(uriHPG1);

        MediaController mediaController= new MediaController(this);
        videoViewHPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewHPG1);

        videoViewHPG1.start();

        videoViewHPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(HeartPage1.this,HeartPage2.class));

            }
        });

        backbtnHPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage1.this,StarPage6.class));

            }
        });

        nextbtnHPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage1.this, HeartPage2.class));

            }
        });
    }
}