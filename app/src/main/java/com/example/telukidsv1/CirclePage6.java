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

public class CirclePage6 extends AppCompatActivity {

    VideoView videoViewCPG6;
    ImageButton backCPG6,nextCPG6;
    String videoPathCPG6;
    Uri uriCPG6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_page6);

        videoViewCPG6 = findViewById(R.id.videoCPG6);
        backCPG6 = findViewById(R.id.btnbackCPG6);
        nextCPG6 = findViewById(R.id.nextbtnCPG6);

        videoPathCPG6 = "android.resource://" + getPackageName() + "/" + R.raw.circle6;
        uriCPG6 = Uri.parse(videoPathCPG6);
        videoViewCPG6.setVideoURI(uriCPG6);

        MediaController mediaController= new MediaController(this);
        videoViewCPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG6);

        videoViewCPG6.start();

        videoViewCPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(CirclePage6.this, SquarePage1.class));

            }
        });

        backCPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CirclePage6.this,CirclePage5.class));
            }
        });

        nextCPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CirclePage6.this, SquarePage1.class));

            }
        });
    }
}