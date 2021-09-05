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

public class RectanglePage2 extends AppCompatActivity {

    VideoView videoViewRPG2;
    String videoPathRPG2;
    Uri uriRPG2;
    ImageButton backbtnRPG2,nextbtnRPG2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_page2);

        videoViewRPG2 = findViewById(R.id.videoRPG2);
        backbtnRPG2 = findViewById(R.id.btnbackRPG2);
        nextbtnRPG2 = findViewById(R.id.nextbtnRPG2);

        videoPathRPG2 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle2;
        uriRPG2 = Uri.parse(videoPathRPG2);
        videoViewRPG2.setVideoURI(uriRPG2);

        MediaController mediaController= new MediaController(this);
        videoViewRPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRPG2);

        videoViewRPG2.start();

        videoViewRPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(RectanglePage2.this, RectanglePage3.class));

            }
        });

        backbtnRPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RectanglePage2.this,RectanglePage1.class));

            }
        });

        nextbtnRPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RectanglePage2.this, RectanglePage3.class));

            }
        });
    }
}