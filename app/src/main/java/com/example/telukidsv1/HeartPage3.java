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

public class HeartPage3 extends AppCompatActivity {

    VideoView videoViewHPG3;
    String videoPathHPG3;
    Uri uriHPG3;
    ImageButton backbtnHPG3,nextbtnHPG3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_page3);

        videoViewHPG3 = findViewById(R.id.videoHPG3);
        backbtnHPG3 = findViewById(R.id.btnbackHPG3);
        nextbtnHPG3 = findViewById(R.id.nextbtnHPG3);

        videoPathHPG3 = "android.resource://" + getPackageName() + "/" + R.raw.heart3;
        uriHPG3 = Uri.parse(videoPathHPG3);
        videoViewHPG3.setVideoURI(uriHPG3);

        MediaController mediaController= new MediaController(this);
        videoViewHPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewHPG3);

        videoViewHPG3.start();

        videoViewHPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(HeartPage3.this,HeartPage4.class));

            }
        });

        backbtnHPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage3.this,HeartPage2.class));

            }
        });

        nextbtnHPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HeartPage3.this, HeartPage4.class));

            }
        });
    }
}