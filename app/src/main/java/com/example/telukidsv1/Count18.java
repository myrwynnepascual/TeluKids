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

public class Count18 extends AppCompatActivity {

    VideoView videoViewC18;
    String videoPathC18;
    Uri uriC18;
    ImageButton backbtnC18,nextbtnC18;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count18);

        videoViewC18 = findViewById(R.id.videoC18);
        backbtnC18 = findViewById(R.id.btnbackC18);
        nextbtnC18 = findViewById(R.id.nextbtnC18);

        videoPathC18 = "android.resource://" + getPackageName() + "/" + R.raw.count18;
        uriC18 = Uri.parse(videoPathC18);
        videoViewC18.setVideoURI(uriC18);

        mediaController = new MediaController(this);
        videoViewC18.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewC18);

        videoViewC18.start();

        videoViewC18.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Count18.this, Count19.class));

            }
        });

        backbtnC18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count18.this,Count17.class));

            }
        });

        nextbtnC18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Count18.this, Count19.class));

            }
        });
    }
}