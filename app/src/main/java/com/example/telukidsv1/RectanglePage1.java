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

public class RectanglePage1 extends AppCompatActivity {

    VideoView videoViewRPG1;
    String videoPathRPG1;
    Uri uriRPG1;
    ImageButton backbtnRPG1,nextbtnRPG1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_page1);

        videoViewRPG1 = findViewById(R.id.videoRPG1);
        backbtnRPG1 = findViewById(R.id.btnbackRPG1);
        nextbtnRPG1 = findViewById(R.id.nextbtnRPG1);

        videoPathRPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle1;
        uriRPG1 = Uri.parse(videoPathRPG1);
        videoViewRPG1.setVideoURI(uriRPG1);

        MediaController mediaController= new MediaController(this);
        videoViewRPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRPG1);

        videoViewRPG1.start();

        videoViewRPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(RectanglePage1.this, RectanglePage2.class));

            }
        });

        backbtnRPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RectanglePage1.this,HeartPage6.class));

            }
        });

        nextbtnRPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RectanglePage1.this, RectanglePage2.class));

            }
        });
    }
}