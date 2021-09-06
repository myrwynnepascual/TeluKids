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

public class Purple3 extends AppCompatActivity {

    VideoView videoViewPUPG3;
    String videoPathPUPG3;
    Uri uriPUPG3;
    ImageButton backbtnPUPG3,nextbtnPUPG3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple3);

        videoViewPUPG3 = findViewById(R.id.videoPUPG3);
        backbtnPUPG3 = findViewById(R.id.btnbackPUPG3);
        nextbtnPUPG3 = findViewById(R.id.nextbtnPUPG3);

        videoPathPUPG3 = "android.resource://" + getPackageName() + "/" + R.raw.purple3;
        uriPUPG3 = Uri.parse(videoPathPUPG3);
        videoViewPUPG3.setVideoURI(uriPUPG3);

        mediaController = new MediaController(this);
        videoViewPUPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewPUPG3);

        videoViewPUPG3.start();

        videoViewPUPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Purple3.this, Purple4.class));

            }
        });

        backbtnPUPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple3.this,Purple2.class));

            }
        });

        nextbtnPUPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Purple3.this, Purple4.class));

            }
        });
    }
}