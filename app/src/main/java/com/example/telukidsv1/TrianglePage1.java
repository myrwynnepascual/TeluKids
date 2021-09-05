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

public class TrianglePage1 extends AppCompatActivity {

    VideoView videoViewTPG1;
    ImageButton backTPG1,nextbtnTPG1;
    String videoPathTPG1;
    Uri uriTPG1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_page1);

        videoViewTPG1 = findViewById(R.id.videoTPG1);
        backTPG1 = findViewById(R.id.btnbackTPG1);
        nextbtnTPG1 = findViewById(R.id.nextbtnTPG1);

        videoPathTPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle1;
        uriTPG1 = Uri.parse(videoPathTPG1);
        videoViewTPG1.setVideoURI(uriTPG1);

        MediaController mediaController= new MediaController(this);
        videoViewTPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewTPG1);

        videoViewTPG1.start();

        videoViewTPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(TrianglePage1.this,TrianglePage2.class));

            }
        });

        backTPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrianglePage1.this,SquarePage6.class));
            }
        });

        nextbtnTPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TrianglePage1.this, TrianglePage2.class));

            }
        });
    }
}