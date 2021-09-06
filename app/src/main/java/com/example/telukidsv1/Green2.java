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

public class Green2 extends AppCompatActivity {

    VideoView videoViewGRPG2;
    String videoPathGRPG2;
    Uri uriGRPG2;
    ImageButton backbtnGRPG2,nextbtnGRPG2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green2);

        videoViewGRPG2 = findViewById(R.id.videoGRPG2);
        backbtnGRPG2 = findViewById(R.id.btnbackGRPG2);
        nextbtnGRPG2 = findViewById(R.id.nextbtnGRPG2);

        videoPathGRPG2 = "android.resource://" + getPackageName() + "/" + R.raw.green2;
        uriGRPG2 = Uri.parse(videoPathGRPG2);
        videoViewGRPG2.setVideoURI(uriGRPG2);

        mediaController = new MediaController(this);
        videoViewGRPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewGRPG2);

        videoViewGRPG2.start();

        videoViewGRPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Green2.this, Green4.class));

            }
        });

        backbtnGRPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green2.this,Green1.class));

            }
        });

        nextbtnGRPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green2.this, Green4.class));

            }
        });
    }
}