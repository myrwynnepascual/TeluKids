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

public class CirclePage4 extends AppCompatActivity {

    VideoView videoViewCPG4;
    ImageButton backCPG4,nextCPG4;
    String videoPathCPG4;
    Uri uriCPG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_page4);

        videoViewCPG4 = findViewById(R.id.videoCPG4);
        backCPG4 = findViewById(R.id.btnbackCPG4);
        nextCPG4 = findViewById(R.id.nextbtnCPG4);

        videoPathCPG4 = "android.resource://" + getPackageName() + "/" + R.raw.circle4;
        uriCPG4 = Uri.parse(videoPathCPG4);
        videoViewCPG4.setVideoURI(uriCPG4);

        MediaController mediaController= new MediaController(this);
        videoViewCPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG4);

        videoViewCPG4.start();

        videoViewCPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(CirclePage4.this, CirclePage5.class));

            }
        });

        backCPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CirclePage4.this,CirclePage3.class));
            }
        });

        nextCPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CirclePage4.this, CirclePage5.class));

            }
        });
    }
}