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

public class Countingx extends AppCompatActivity {

    VideoView videoViewCX;
    String videoPathCX;
    Uri uriCX;
    ImageButton backbtnCX,nextbtnCX;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countingx);

        videoViewCX = findViewById(R.id.videoCX);
        backbtnCX = findViewById(R.id.btnbackCX);
        nextbtnCX = findViewById(R.id.nextbtnCX);

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.countx;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Countingx.this, Count1.class));

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Countingx.this,ChooseModeCounting.class));

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Countingx.this, Count1.class));

            }
        });
    }
}