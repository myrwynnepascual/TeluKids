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

public class TrianglePage6 extends AppCompatActivity {

    VideoView videoViewTPG6;
    ImageButton backTPG6,nextbtnTPG6;
    String videoPathTPG6;
    Uri uriTPG6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_page6);

        videoViewTPG6 = findViewById(R.id.videoTPG6);
        backTPG6 = findViewById(R.id.btnbackTPG6);
        nextbtnTPG6 = findViewById(R.id.nextbtnTPG6);

        videoPathTPG6 = "android.resource://" + getPackageName() + "/" + R.raw.triangle6;
        uriTPG6 = Uri.parse(videoPathTPG6);
        videoViewTPG6.setVideoURI(uriTPG6);

        MediaController mediaController= new MediaController(this);
        videoViewTPG6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewTPG6);

        videoViewTPG6.start();

        videoViewTPG6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(TrianglePage6.this,StarPage1.class));

            }
        });

        backTPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrianglePage6.this,TrianglePage5.class));
            }
        });

        nextbtnTPG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TrianglePage6.this, StarPage1.class));

            }
        });
    }
}