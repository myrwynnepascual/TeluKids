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

public class HeartPage6 extends AppCompatActivity {

    VideoView videoViewHPG6;
    String videoPathHPG6;
    Uri uriHPG6;
    ImageButton backbtnHPG6,nextbtnHPG6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_page6);

        videoViewHPG6 = findViewById(R.id.videoHPG6);
        backbtnHPG6 = findViewById(R.id.btnbackHPG6);
        nextbtnHPG6 = findViewById(R.id.nextbtnHPG6);

        videoPathHPG6 = "android.resource://" + getPackageName() + "/" + R.raw.heart6;
        uriHPG6 = Uri.parse(videoPathHPG6);
        videoViewHPG6.setVideoURI(uriHPG6);

        MediaController mediaController= new MediaController(this);
        videoViewHPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewHPG6);

        videoViewHPG6.start();

        videoViewHPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(HeartPage6.this,RectanglePage1.class));

            }
        });

        backbtnHPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage6.this,HeartPage5.class));

            }
        });

        nextbtnHPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage6.this, RectanglePage1.class));

            }
        });
    }
}