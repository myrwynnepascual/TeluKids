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

public class Count19 extends AppCompatActivity {

    VideoView videoViewC19;
    String videoPathC19;
    Uri uriC19;
    ImageButton backbtnC19,nextbtnC19;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count19);

        videoViewC19 = findViewById(R.id.videoC19);
        backbtnC19 = findViewById(R.id.btnbackC19);
        nextbtnC19 = findViewById(R.id.nextbtnC19);

        videoPathC19 = "android.resource://" + getPackageName() + "/" + R.raw.count19;
        uriC19 = Uri.parse(videoPathC19);
        videoViewC19.setVideoURI(uriC19);

        mediaController = new MediaController(this);
        videoViewC19.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC19);

        videoViewC19.start();

        videoViewC19.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count19.this, Count20.class));

            }
        });

        backbtnC19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count19.this,Count18.class));

            }
        });

        nextbtnC19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count19.this, Count20.class));

            }
        });
    }
}