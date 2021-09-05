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

public class HeartPage5 extends AppCompatActivity {

    VideoView videoViewHPG5;
    String videoPathHPG5;
    Uri uriHPG5;
    ImageButton backbtnHPG5,nextbtnHPG5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_page5);

        videoViewHPG5 = findViewById(R.id.videoHPG5);
        backbtnHPG5 = findViewById(R.id.btnbackHPG5);
        nextbtnHPG5 = findViewById(R.id.nextbtnHPG5);

        videoPathHPG5 = "android.resource://" + getPackageName() + "/" + R.raw.heart5;
        uriHPG5 = Uri.parse(videoPathHPG5);
        videoViewHPG5.setVideoURI(uriHPG5);

        MediaController mediaController= new MediaController(this);
        videoViewHPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewHPG5);

        videoViewHPG5.start();

        videoViewHPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(HeartPage5.this,HeartPage6.class));

            }
        });

        backbtnHPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage5.this,HeartPage4.class));

            }
        });

        nextbtnHPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage5.this, HeartPage6.class));

            }
        });
    }
}