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

public class TrianglePage5 extends AppCompatActivity {

    VideoView videoViewTPG5;
    ImageButton backTPG5,nextbtnTPG5;
    String videoPathTPG5;
    Uri uriTPG5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_page5);

        videoViewTPG5 = findViewById(R.id.videoTPG5);
        backTPG5 = findViewById(R.id.btnbackTPG5);
        nextbtnTPG5 = findViewById(R.id.nextbtnTPG5);

        videoPathTPG5 = "android.resource://" + getPackageName() + "/" + R.raw.triangle5;
        uriTPG5 = Uri.parse(videoPathTPG5);
        videoViewTPG5.setVideoURI(uriTPG5);

        MediaController mediaController= new MediaController(this);
        videoViewTPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewTPG5);

        videoViewTPG5.start();

        videoViewTPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(TrianglePage5.this,TrianglePage6.class));

            }
        });

        backTPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TrianglePage5.this,TrianglePage4.class));
            }
        });

        nextbtnTPG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TrianglePage5.this, TrianglePage6.class));

            }
        });
    }
}