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

public class Addition1 extends AppCompatActivity {

    VideoView videoViewA1;
    String videoPathA1;
    Uri uriA1;
    ImageButton backbtnA1,nextbtnA1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition1);

        videoViewA1 = findViewById(R.id.videoA1);
        backbtnA1 = findViewById(R.id.btnbackA1);
        nextbtnA1 = findViewById(R.id.nextbtnA1);

        videoPathA1 = "android.resource://" + getPackageName() + "/" + R.raw.addition1;
        uriA1 = Uri.parse(videoPathA1);
        videoViewA1.setVideoURI(uriA1);

        mediaController = new MediaController(this);
        videoViewA1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA1);

        videoViewA1.start();

        videoViewA1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition1.this, Addition2.class));

            }
        });

        backbtnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition1.this,Additionx.class));

            }
        });

        nextbtnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition1.this, Addition2.class));

            }
        });
    }
}