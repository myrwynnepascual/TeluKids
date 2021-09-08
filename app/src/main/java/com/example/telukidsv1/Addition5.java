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

public class Addition5 extends AppCompatActivity {

    VideoView videoViewA5;
    String videoPathA5;
    Uri uriA5;
    ImageButton backbtnA5,nextbtnA5;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition5);

        videoViewA5 = findViewById(R.id.videoA5);
        backbtnA5 = findViewById(R.id.btnbackA5);
        nextbtnA5 = findViewById(R.id.nextbtnA5);

        videoPathA5 = "android.resource://" + getPackageName() + "/" + R.raw.addition5;
        uriA5 = Uri.parse(videoPathA5);
        videoViewA5.setVideoURI(uriA5);

        mediaController = new MediaController(this);
        videoViewA5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA5);

        videoViewA5.start();

        videoViewA5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition5.this, Addition6.class));

            }
        });

        backbtnA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition5.this,Addition4.class));

            }
        });

        nextbtnA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition5.this, Addition6.class));

            }
        });
    }
}