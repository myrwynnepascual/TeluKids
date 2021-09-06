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

public class Green1 extends AppCompatActivity {

    VideoView videoViewGRPG1;
    String videoPathGRPG1;
    Uri uriGRPG1;
    ImageButton backbtnGRPG1,nextbtnGRPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green1);

        videoViewGRPG1 = findViewById(R.id.videoGRPG1);
        backbtnGRPG1 = findViewById(R.id.btnbackGRPG1);
        nextbtnGRPG1 = findViewById(R.id.nextbtnGRPG1);

        videoPathGRPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green1;
        uriGRPG1 = Uri.parse(videoPathGRPG1);
        videoViewGRPG1.setVideoURI(uriGRPG1);

        mediaController = new MediaController(this);
        videoViewGRPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewGRPG1);

        videoViewGRPG1.start();

        videoViewGRPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Green1.this, Green2.class));

            }
        });

        backbtnGRPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green1.this,Purple6.class));

            }
        });

        nextbtnGRPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green1.this, Green2.class));

            }
        });
    }
}