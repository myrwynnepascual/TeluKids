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

public class HeartPage4 extends AppCompatActivity {

    VideoView videoViewHPG4;
    String videoPathHPG4;
    Uri uriHPG4;
    ImageButton backbtnHPG4,nextbtnHPG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_page4);

        videoViewHPG4 = findViewById(R.id.videoHPG4);
        backbtnHPG4 = findViewById(R.id.btnbackHPG4);
        nextbtnHPG4 = findViewById(R.id.nextbtnHPG4);

        videoPathHPG4 = "android.resource://" + getPackageName() + "/" + R.raw.heart4;
        uriHPG4 = Uri.parse(videoPathHPG4);
        videoViewHPG4.setVideoURI(uriHPG4);

        MediaController mediaController= new MediaController(this);
        videoViewHPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewHPG4);

        videoViewHPG4.start();

        videoViewHPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(HeartPage4.this,HeartPage5.class));

            }
        });

        backbtnHPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage4.this,HeartPage3.class));

            }
        });

        nextbtnHPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage4.this, HeartPage5.class));

            }
        });
    }
}