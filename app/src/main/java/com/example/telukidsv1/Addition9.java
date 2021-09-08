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

public class Addition9 extends AppCompatActivity {

    VideoView videoViewA9;
    String videoPathA9;
    Uri uriA9;
    ImageButton backbtnA9,nextbtnA9;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition9);

        videoViewA9 = findViewById(R.id.videoA9);
        backbtnA9 = findViewById(R.id.btnbackA9);
        nextbtnA9 = findViewById(R.id.nextbtnA9);

        videoPathA9 = "android.resource://" + getPackageName() + "/" + R.raw.addition9;
        uriA9 = Uri.parse(videoPathA9);
        videoViewA9.setVideoURI(uriA9);

        mediaController = new MediaController(this);
        videoViewA9.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA9);

        videoViewA9.start();

        videoViewA9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition9.this, Addition10.class));

            }
        });

        backbtnA9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition9.this,Addition8.class));

            }
        });

        nextbtnA9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition9.this, Addition10.class));

            }
        });
    }
}