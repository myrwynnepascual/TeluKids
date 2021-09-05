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

public class TrianglePage4 extends AppCompatActivity {

    VideoView videoViewTPG4;
    ImageButton backTPG4,nextbtnTPG4;
    String videoPathTPG4;
    Uri uriTPG4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_page4);

        videoViewTPG4 = findViewById(R.id.videoTPG4);
        backTPG4 = findViewById(R.id.btnbackTPG4);
        nextbtnTPG4 = findViewById(R.id.nextbtnTPG4);

        videoPathTPG4 = "android.resource://" + getPackageName() + "/" + R.raw.triangle4;
        uriTPG4 = Uri.parse(videoPathTPG4);
        videoViewTPG4.setVideoURI(uriTPG4);

        MediaController mediaController= new MediaController(this);
        videoViewTPG4.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewTPG4);

        videoViewTPG4.start();

        videoViewTPG4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(TrianglePage4.this,TrianglePage5.class));

            }
        });

        backTPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrianglePage4.this,TrianglePage3.class));
            }
        });

        nextbtnTPG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TrianglePage4.this, TrianglePage5.class));

            }
        });
    }
}