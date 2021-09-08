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

public class Addition10 extends AppCompatActivity {

    VideoView videoViewA10;
    String videoPathA10;
    Uri uriA10;
    ImageButton backbtnA10,nextbtnA10;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition10);

        videoViewA10 = findViewById(R.id.videoA10);
        backbtnA10 = findViewById(R.id.btnbackA10);
        nextbtnA10 = findViewById(R.id.nextbtnA10);

        videoPathA10 = "android.resource://" + getPackageName() + "/" + R.raw.addition10;
        uriA10 = Uri.parse(videoPathA10);
        videoViewA10.setVideoURI(uriA10);

        mediaController = new MediaController(this);
        videoViewA10.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA10);

        videoViewA10.start();

        videoViewA10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition10.this, AdditionLessonCongrats.class));

            }
        });

        backbtnA10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition10.this,Addition9.class));

            }
        });

        nextbtnA10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition10.this, AdditionLessonCongrats.class));

            }
        });
    }
}