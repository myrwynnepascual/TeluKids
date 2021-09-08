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

public class Count17 extends AppCompatActivity {

    VideoView videoViewC17;
    String videoPathC17;
    Uri uriC17;
    ImageButton backbtnC17,nextbtnC17;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count17);
        
        videoViewC17 = findViewById(R.id.videoC17);
        backbtnC17 = findViewById(R.id.btnbackC17);
        nextbtnC17 = findViewById(R.id.nextbtnC17);

        videoPathC17 = "android.resource://" + getPackageName() + "/" + R.raw.count17;
        uriC17 = Uri.parse(videoPathC17);
        videoViewC17.setVideoURI(uriC17);

        mediaController = new MediaController(this);
        videoViewC17.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC17);

        videoViewC17.start();

        videoViewC17.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count17.this, Count18.class));

            }
        });

        backbtnC17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count17.this,Count16.class));

            }
        });

        nextbtnC17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count17.this, Count18.class));

            }
        });
    }
}