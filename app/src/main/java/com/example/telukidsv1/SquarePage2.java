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
import android.widget.VideoView;

public class SquarePage2 extends AppCompatActivity {

    VideoView videoViewSPG2;
    ImageButton backSPG2,nextbtnSPG2;
    String videoPathSPG2;
    Uri uriSPG2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_page2);

        videoViewSPG2 = findViewById(R.id.videoSPG2);
        backSPG2 = findViewById(R.id.btnbackSPG2);
        nextbtnSPG2 = findViewById(R.id.nextbtnSPG2);

        videoPathSPG2 = "android.resource://" + getPackageName() + "/" + R.raw.square2;
        uriSPG2 = Uri.parse(videoPathSPG2);
        videoViewSPG2.setVideoURI(uriSPG2);

        MediaController mediaController= new MediaController(this);
        videoViewSPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSPG2);

        videoViewSPG2.start();

        videoViewSPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(SquarePage2.this,SquarePage3.class));

            }
        });

        backSPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SquarePage2.this,SquarePage1.class));
            }
        });

        nextbtnSPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SquarePage2.this, SquarePage3.class));

            }
        });
    }
}