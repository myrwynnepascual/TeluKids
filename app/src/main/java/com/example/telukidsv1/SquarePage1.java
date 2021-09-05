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

public class SquarePage1 extends AppCompatActivity {

    VideoView videoViewSPG1;
    ImageButton backSPG1,nextSPG1;
    String videoPathSPG1;
    Uri uriSPG1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_page1);

        videoViewSPG1 = findViewById(R.id.videoSPG1);
        backSPG1 = findViewById(R.id.btnbackSPG1);
        nextSPG1 = findViewById(R.id.nextbtnSPG1);

        videoPathSPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square1;
        uriSPG1 = Uri.parse(videoPathSPG1);
        videoViewSPG1.setVideoURI(uriSPG1);

        MediaController mediaController= new MediaController(this);
        videoViewSPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSPG1);

        videoViewSPG1.start();

        videoViewSPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(SquarePage1.this,SquarePage2.class));

            }
        });

        backSPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SquarePage1.this,CirclePage6.class));
            }
        });

        nextSPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SquarePage1.this, SquarePage2.class));

            }
        });
    }
}