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

public class SquarePage4 extends AppCompatActivity {

    VideoView videoViewSPG4;
    ImageButton backSPG4,nextbtnSPG4;
    String videoPathSPG4;
    Uri uriSPG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_page4);

        videoViewSPG4 = findViewById(R.id.videoSPG4);
        backSPG4 = findViewById(R.id.btnbackSPG4);
        nextbtnSPG4 = findViewById(R.id.nextbtnSPG4);

        videoPathSPG4 = "android.resource://" + getPackageName() + "/" + R.raw.square4;
        uriSPG4 = Uri.parse(videoPathSPG4);
        videoViewSPG4.setVideoURI(uriSPG4);

        MediaController mediaController= new MediaController(this);
        videoViewSPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSPG4);

        videoViewSPG4.start();

        videoViewSPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(SquarePage4.this,SquarePage5.class));

            }
        });

        backSPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SquarePage4.this,SquarePage3.class));
            }
        });

        nextbtnSPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SquarePage4.this, SquarePage5.class));

            }
        });
    }
}