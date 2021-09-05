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

public class TrianglePage2 extends AppCompatActivity {

    VideoView videoViewTPG2;
    ImageButton backTPG2,nextbtnTPG2;
    String videoPathTPG2;
    Uri uriTPG2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_page2);

        videoViewTPG2 = findViewById(R.id.videoTPG2);
        backTPG2 = findViewById(R.id.btnbackTPG2);
        nextbtnTPG2 = findViewById(R.id.nextbtnTPG2);

        videoPathTPG2 = "android.resource://" + getPackageName() + "/" + R.raw.triangle2;
        uriTPG2 = Uri.parse(videoPathTPG2);
        videoViewTPG2.setVideoURI(uriTPG2);

        MediaController mediaController= new MediaController(this);
        videoViewTPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewTPG2);

        videoViewTPG2.start();

        videoViewTPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(TrianglePage2.this,TrianglePage3.class));

            }
        });

        backTPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrianglePage2.this,TrianglePage1.class));
            }
        });

        nextbtnTPG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TrianglePage2.this, TrianglePage3.class));

            }
        });
    }
}