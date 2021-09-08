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

public class Addition2 extends AppCompatActivity {

    VideoView videoViewA2;
    String videoPathA2;
    Uri uriA2;
    ImageButton backbtnA2,nextbtnA2;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition2);

        videoViewA2 = findViewById(R.id.videoA2);
        backbtnA2 = findViewById(R.id.btnbackA2);
        nextbtnA2 = findViewById(R.id.nextbtnA2);

        videoPathA2 = "android.resource://" + getPackageName() + "/" + R.raw.addition2;
        uriA2 = Uri.parse(videoPathA2);
        videoViewA2.setVideoURI(uriA2);

        mediaController = new MediaController(this);
        videoViewA2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA2);

        videoViewA2.start();

        videoViewA2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition2.this, Addition3.class));

            }
        });

        backbtnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition2.this,Addition1.class));

            }
        });

        nextbtnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition2.this, Addition3.class));

            }
        });
    }
}