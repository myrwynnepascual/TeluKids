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

public class Addition4 extends AppCompatActivity {

    VideoView videoViewA4;
    String videoPathA4;
    Uri uriA4;
    ImageButton backbtnA4,nextbtnA4;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition4);

        videoViewA4 = findViewById(R.id.videoA4);
        backbtnA4 = findViewById(R.id.btnbackA4);
        nextbtnA4 = findViewById(R.id.nextbtnA4);

        videoPathA4 = "android.resource://" + getPackageName() + "/" + R.raw.addition4;
        uriA4 = Uri.parse(videoPathA4);
        videoViewA4.setVideoURI(uriA4);

        mediaController = new MediaController(this);
        videoViewA4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA4);

        videoViewA4.start();

        videoViewA4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition4.this, Addition5.class));

            }
        });

        backbtnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition4.this,Addition3.class));

            }
        });

        nextbtnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition4.this, Addition5.class));

            }
        });
    }
}