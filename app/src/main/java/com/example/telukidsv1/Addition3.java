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

public class Addition3 extends AppCompatActivity {

    VideoView videoViewA3;
    String videoPathA3;
    Uri uriA3;
    ImageButton backbtnA3,nextbtnA3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition3);

        videoViewA3 = findViewById(R.id.videoA3);
        backbtnA3 = findViewById(R.id.btnbackA3);
        nextbtnA3 = findViewById(R.id.nextbtnA3);

        videoPathA3 = "android.resource://" + getPackageName() + "/" + R.raw.addition3;
        uriA3 = Uri.parse(videoPathA3);
        videoViewA3.setVideoURI(uriA3);

        mediaController = new MediaController(this);
        videoViewA3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA3);

        videoViewA3.start();

        videoViewA3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition3.this, Addition4.class));

            }
        });

        backbtnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition3.this,Addition2.class));

            }
        });

        nextbtnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition3.this, Addition4.class));

            }
        });
    }
}