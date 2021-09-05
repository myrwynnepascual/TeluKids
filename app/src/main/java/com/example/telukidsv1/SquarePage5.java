package com.example.telukidsv1;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class SquarePage5 extends AppCompatActivity {

    VideoView videoViewSPG5;
    ImageButton backSPG5,nextbtnSPG5;
    String videoPathSPG5;
    Uri uriSPG5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_page5);

        videoViewSPG5 = findViewById(R.id.videoSPG5);
        backSPG5 = findViewById(R.id.btnbackSPG5);
        nextbtnSPG5 = findViewById(R.id.nextbtnSPG5);

        videoPathSPG5 = "android.resource://" + getPackageName() + "/" + R.raw.square5;
        uriSPG5 = Uri.parse(videoPathSPG5);
        videoViewSPG5.setVideoURI(uriSPG5);

        MediaController mediaController= new MediaController(this);
        videoViewSPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSPG5);

        videoViewSPG5.start();

        videoViewSPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(SquarePage5.this,SquarePage6.class));

            }
        });

        backSPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SquarePage5.this,SquarePage4.class));
            }
        });

        nextbtnSPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SquarePage5.this, SquarePage6.class));

            }
        });
    }
}