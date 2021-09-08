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

public class Addition8 extends AppCompatActivity {

    VideoView videoViewA8;
    String videoPathA8;
    Uri uriA8;
    ImageButton backbtnA8,nextbtnA8;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition8);

        videoViewA8 = findViewById(R.id.videoA8);
        backbtnA8 = findViewById(R.id.btnbackA8);
        nextbtnA8 = findViewById(R.id.nextbtnA8);

        videoPathA8 = "android.resource://" + getPackageName() + "/" + R.raw.addition8;
        uriA8 = Uri.parse(videoPathA8);
        videoViewA8.setVideoURI(uriA8);

        mediaController = new MediaController(this);
        videoViewA8.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA8);

        videoViewA8.start();

        videoViewA8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition8.this, Addition9.class));

            }
        });

        backbtnA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition8.this,Addition7.class));

            }
        });

        nextbtnA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition8.this, Addition9.class));

            }
        });
    }
}