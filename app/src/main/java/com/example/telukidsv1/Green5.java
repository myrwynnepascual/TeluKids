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

public class Green5 extends AppCompatActivity {

    VideoView videoViewGRPG5;
    String videoPathGRPG5;
    Uri uriGRPG5;
    ImageButton backbtnGRPG5,nextbtnGRPG5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green5);

        videoViewGRPG5 = findViewById(R.id.videoGRPG5);
        backbtnGRPG5 = findViewById(R.id.btnbackGRPG5);
        nextbtnGRPG5 = findViewById(R.id.nextbtnGRPG5);

        videoPathGRPG5 = "android.resource://" + getPackageName() + "/" + R.raw.green5;
        uriGRPG5 = Uri.parse(videoPathGRPG5);
        videoViewGRPG5.setVideoURI(uriGRPG5);

        mediaController = new MediaController(this);
        videoViewGRPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewGRPG5);

        videoViewGRPG5.start();

        videoViewGRPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Green5.this, Green6.class));

            }
        });

        backbtnGRPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green5.this,Green4.class));

            }
        });

        nextbtnGRPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green5.this, Green6.class));

            }
        });
    }
}