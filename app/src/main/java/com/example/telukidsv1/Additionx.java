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

public class Additionx extends AppCompatActivity {

    VideoView videoViewAX;
    String videoPathAX;
    Uri uriAX;
    ImageButton backbtnAX,nextbtnAX;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additionx);

        videoViewAX = findViewById(R.id.videoAX);
        backbtnAX = findViewById(R.id.btnbackAX);
        nextbtnAX = findViewById(R.id.nextbtnAX);

        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.additionx;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        mediaController = new MediaController(this);
        videoViewAX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Additionx.this, Addition1.class));

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Additionx.this,ChooseModeAddition.class));

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Additionx.this, Addition1.class));

            }
        });
    }
}