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

public class Yellow1 extends AppCompatActivity {

    VideoView videoViewYEPG1;
    String videoPathYEPG1;
    Uri uriYEPG1;
    ImageButton backbtnYEPG1,nextbtnYEPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow1);

        videoViewYEPG1 = findViewById(R.id.videoYEPG1);
        backbtnYEPG1 = findViewById(R.id.btnbackYEPG1);
        nextbtnYEPG1 = findViewById(R.id.nextbtnYEPG1);

        videoPathYEPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow1;
        uriYEPG1 = Uri.parse(videoPathYEPG1);
        videoViewYEPG1.setVideoURI(uriYEPG1);

        mediaController = new MediaController(this);
        videoViewYEPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewYEPG1);

        videoViewYEPG1.start();

        videoViewYEPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Yellow1.this, Yellow2.class));

            }
        });

        backbtnYEPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow1.this,Blue6.class));

            }
        });

        nextbtnYEPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Yellow1.this, Yellow2.class));

            }
        });
    }
}