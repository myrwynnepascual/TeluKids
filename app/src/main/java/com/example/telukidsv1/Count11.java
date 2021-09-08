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

public class Count11 extends AppCompatActivity {

    VideoView videoViewC11;
    String videoPathC11;
    Uri uriC11;
    ImageButton backbtnC11,nextbtnC11;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count11);

        videoViewC11 = findViewById(R.id.videoC11);
        backbtnC11 = findViewById(R.id.btnbackC11);
        nextbtnC11 = findViewById(R.id.nextbtnC11);

        videoPathC11 = "android.resource://" + getPackageName() + "/" + R.raw.count11;
        uriC11 = Uri.parse(videoPathC11);
        videoViewC11.setVideoURI(uriC11);

        mediaController = new MediaController(this);
        videoViewC11.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC11);

        videoViewC11.start();

        videoViewC11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count11.this, Count12.class));

            }
        });

        backbtnC11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count11.this,Count10.class));

            }
        });

        nextbtnC11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count11.this, Count12.class));

            }
        });
    }
}