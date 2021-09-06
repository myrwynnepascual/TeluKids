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

public class Green4 extends AppCompatActivity {

    VideoView videoViewGRPG4;
    String videoPathGRPG4;
    Uri uriGRPG4;
    ImageButton backbtnGRPG4,nextbtnGRPG4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green4);

        videoViewGRPG4 = findViewById(R.id.videoGRPG4);
        backbtnGRPG4 = findViewById(R.id.btnbackGRPG4);
        nextbtnGRPG4 = findViewById(R.id.nextbtnGRPG4);

        videoPathGRPG4 = "android.resource://" + getPackageName() + "/" + R.raw.green4;
        uriGRPG4 = Uri.parse(videoPathGRPG4);
        videoViewGRPG4.setVideoURI(uriGRPG4);

        mediaController = new MediaController(this);
        videoViewGRPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewGRPG4);

        videoViewGRPG4.start();

        videoViewGRPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Green4.this, Green5.class));

            }
        });

        backbtnGRPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green4.this,Green3.class));

            }
        });

        nextbtnGRPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green4.this, Green5.class));

            }
        });
    }
}